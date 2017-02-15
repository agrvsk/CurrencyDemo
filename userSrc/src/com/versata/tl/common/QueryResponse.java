package com.versata.tl.common;

import com.versata.tl.api.itext.MessageCode;
import com.versata.tl.api.logging.VersataLogger;
import com.versata.tl.common.VSORBResultSetPackage.atEndException;
import com.versata.tl.common.text.VSapiMsgCode;
import com.versata.tl.common.util.ZipCompressionAlg;
import com.versata.tl.common.vlsobject.VSORBException;
import com.versata.tl.common.vlsobject.VSORBResultSet;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Arrays;

/**
 * @internal.tle This class is used to pass the query response to client for all types of query.
 */
public class QueryResponse implements Serializable {

    private static final VersataLogger _LOGGER = VersataLogger.getLogger(QueryResponse.class);
    private static final String _RCS_HEADER = "$Header: //depot/main/products/brms/runtime/src/core/com/versata/tl/common/QueryResponse.java#1 $";

    private static final long serialVersionUID = 6331680469858485916L;

    static {
        VersataLogger.getRCSTraceLogger().trace(_RCS_HEADER);
    }

    private int count;
    private VSORBResultSet rs;
    private String[][] rows;
    private byte[] rowsAsBytes;
    private MetaColumn[] metaColumn;
    private QueryRequest qr;
    private Object[][] objectRows;

    /**
     * Method setQueryRequest.
     *
     * @param qr QueryRequest
     */
    public void setQueryRequest(QueryRequest qr) {
        this.qr = qr;
    }

    /**
     * Method setRowCount.
     *
     * @param cnt int
     */
    public void setRowCount(int cnt) {
        count = cnt;
    }

    /**
     * Method getRowCount.
     *
     * @return int
     */
    public int getRowCount() {
        return count;
    }

    /**
     * Method setMetaColumn.
     *
     * @param metaColumn MetaColumn[]
     */
    public void setMetaColumn(MetaColumn[] metaColumn) {
        this.metaColumn = metaColumn;
    }

    /**
     * Method getMetaColumn.
     *
     * @return MetaColumn[]
     */
    public MetaColumn[] getMetaColumn() {
        return metaColumn;
    }

    /**
     * Method setRS.
     *
     * @param RS VSORBResultSet
     */
    public void setRS(VSORBResultSet RS) {
        rs = RS;
    }

    /**
     * Method getRS.
     *
     * @return VSORBResultSet
     */
    public VSORBResultSet getRS() {
        return rs;
    }

    /**
     * Method setRows.
     *
     * @param theRows String[][]
     */
    public void setRows(String[][] theRows) {
        //Compress the rows
        if (qr.isCompressRows()) {
            if (theRows != null) {
                rowsAsBytes = getCompressionAlg().compressStrings(theRows);
            } else {
                rowsAsBytes = null;
            }
        } else {
            rows = theRows;
        }

        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug("QueryResponse->setRows : rows " + rows + " rowsAsBytes : " + rowsAsBytes + " theRows :" + theRows);
        }
    }

    /**
     * Method getRows.
     *
     * @return String[][]
     * @throws atEndException
     */
    public String[][] getRows() throws atEndException {

        if (qr.isCompressRows()) {
            String[][] decompressedRows = null;
            if (rowsAsBytes != null) {
                decompressedRows = getCompressionAlg().decompressStrings(rowsAsBytes);
            }
            return decompressedRows;
        } else {
            return rows;
        }
    }

    /**
     * Method setRowsAsObjects.
     *
     * @param objectRows Object[][]
     */
    public void setRowsAsObjects(Object[][] objectRows) {
        this.objectRows = objectRows;
    }

    /**
     * Method getRowsAsObjects.
     *
     * @return Object[][]
     * @throws atEndException
     */
    public Object[][] getRowsAsObjects() throws atEndException {
        return objectRows;
    }

    /**
     * Method getCompressionAlg.
     *
     * @return ZipCompressionAlg
     */
    public ZipCompressionAlg getCompressionAlg() {
        return CommonFactory.getInstance().getCompressionAlg();
    }

    //
    //  Wrapper functions for VSORBResutlSet
    //

    /**
     * Method fetchRows.
     *
     * @return String[][]
     * @throws atEndException
     * @throws VSORBException
     * @throws RemoteException
     */
    public String[][] fetchRows() throws atEndException, VSORBException, RemoteException {

        String[][] rows = getRows();
        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug("QueryResponse->fetchRows rows = : " + rows);
        }

        if (rows != null && rows.length != 0) {
            setRows(null);
            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug("Returning the first block of rows ");
            }
            return rows;
        }
        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug("No first block of rows. Trying to get from the remote resultset");
        }

        isValidRS(VSapiMsgCode.REMOTE_RESULTSET_NOT_CLOSED);

        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug("Trying to fetch from remote resultset");
        }
        return qr.isCompressRows() ? getCompressionAlg().decompressStrings(rs.fetchRowsAsBytes()) : rs.fetchRows();
    }

    private void isValidRS(MessageCode msgCode) throws atEndException {
        if (rs == null) {
            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug("QueryResponse.isValidRS There is no remote resultset. Throwing Exception()");
            }
            throw new atEndException(msgCode);
        }
    }

    /**
     * Method localFetch.
     *
     * @return Object[][]
     * @throws atEndException
     * @throws VSORBException
     * @throws RemoteException
     */
    public Object[][] localFetch() throws atEndException, VSORBException, RemoteException {
        Object[][] rows = getRowsAsObjects();
        if (rows != null && rows.length != 0) {
            setRowsAsObjects(null);
            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug("QueryResponse->localFetch Returning the first block of rows with a total of = " + rows.length);
            }
            return rows;
        }
        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug("QueryResponse->localFetch No first block of rows. Trying to get from the remote resultset");
        }

        isValidRS(VSapiMsgCode.REMOTE_RESULTSET_NOT_CLOSED);
        return ((CoLocatedResultSet)((_tie_VSORBResultSet)rs)._delegate()).localFetch();
    }

    /**
     * Method setCursorPosition.
     *
     * @param position int
     * @return boolean
     * @throws VSORBException
     * @throws RemoteException
     * @throws atEndException
     */
    public boolean setCursorPosition(int position) throws VSORBException, RemoteException, atEndException {
        isValidRS(VSapiMsgCode.REMOTE_RESULTSET_NOT_CLOSED);
        return rs.setCursorPosition(position);
    }

    /**
     * Method fetch.
     *
     * @param Rows RowSeqHolder
     * @return int
     * @throws atEndException
     * @throws VSORBException
     * @throws RemoteException
     */
    public int fetch(RowSeqHolder Rows) throws atEndException, VSORBException, RemoteException {
        isValidRS(VSapiMsgCode.REMOTE_RESULTSET_NOT_CLOSED);
        return rs.fetch(Rows);
    }

    /**
     * Method getCount.
     *
     * @return int
     * @throws RemoteException
     * @throws atEndException
     */
    public int getCount() throws RemoteException, atEndException {
        if (qr.getUseStatelessRS() || qr.getPrefetchRowCount()) {
            return getRowCount();
        }
        isValidRS(VSapiMsgCode.REMOTE_RESULTSET_NOT_CLOSED);
        return rs.getCount();
    }

    /**
     * Method getRowCount.
     *
     * @param forcePrefetch boolean
     * @return int
     * @throws RemoteException
     * @throws atEndException
     */
    public int getRowCount(boolean forcePrefetch) throws RemoteException, atEndException {
        if (!forcePrefetch) {
            return getRowCount();
        }
        isValidRS(VSapiMsgCode.REMOTE_RESULTSET_NOT_CLOSED);
        return rs.getCount();
    }

    /**
     * Method registerMetaData.
     *
     * @return MetaColumn[]
     * @throws VSORBException
     * @throws RemoteException
     */
    public MetaColumn[] registerMetaData() throws VSORBException, RemoteException {
        //Return the cached meta column. This value will be null for Code Tables, console and security session.
        return getMetaColumn();
    }

    /**
     * Method setColumnProjectionLevel.
     *
     * @param level int
     * @throws RemoteException
     * @throws atEndException
     */
    public void setColumnProjectionLevel(int level) throws RemoteException, atEndException {
        isValidRS(VSapiMsgCode.REMOTE_RESULTSET_NOT_CLOSED);
        rs.setColumnProjectionLevel(level);
    }

    /**
     * Method close.
     *
     * @throws RemoteException
     */
    public void close() throws RemoteException {

        if (rs != null) {
            try {
                rs.close();
            } finally {
                rs = null;
            }
        }
    }

    /**
     * Method toString.
     * @return String
     */
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("QueryResponse{");
        buf.append("count=" + count);
        buf.append(", rs=" + rs);
        buf.append(", rows=" + (rows == null ? null : Arrays.asList(rows)));
        buf.append(", rowsAsBytes=" + rowsAsBytes);
        buf.append(", metaColumn=" + (metaColumn == null ? null : Arrays.asList(metaColumn)));
        buf.append(", qr=" + qr);
        buf.append(", objectRows=" + (objectRows == null ? null : Arrays.asList(objectRows)) + '}');
        return buf.toString();
	}
}