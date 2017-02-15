<?xml version="1.0" encoding="UTF-8"?>
<builderextension:Builder xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:builderextension="http://www.versata.com/6.0/builderextension">
  <builderNode enabled="true" id="VersataBuilder" name="VersataBuilder">
    <subBuilders enabled="true" id="BusinessModelBuilderGroup" name="BusinessModelBuilderGroup">
      <subBuilders enabled="true" hasBuilderForCurrentNode="true" id="JavaRCompileBuilder" name="JavaRCompileBuilder" deltaVisitor="VersataModelsVisitor"/>
      <subBuilders enabled="true" hasBuilderForCurrentNode="true" id="RCompileBuilder" name="RCompileBuilder" deltaVisitor="VersataModelsVisitor"/>
      <subBuilders enabled="true" hasBuilderForCurrentNode="true" id="CustomTemplateBuilder" name="CustomTemplateBuilder" deltaVisitor="VersataModelsVisitor"/>
    </subBuilders>
    <subBuilders enabled="true" hasBuilderForCurrentNode="true" id="VersataModelValidationBuilder" name="VersataModelValidationBuilder" deltaVisitor="VersataModelValidationVisitor"/>
    <subBuilders enabled="true" id="VersataServicesBuilderGroup" name="VersataServicesBuilderGroup">
      <subBuilders enabled="true" hasBuilderForCurrentNode="true" id="RepoDependenciesBuilder" name="RepoDependenciesBuilder" deltaVisitor="VersataServicesVisitor"/>
      <subBuilders enabled="true" hasBuilderForCurrentNode="true" id="SDOBuilder" name="SDOBuilder" deltaVisitor="VersataServicesVisitor"/>
    </subBuilders>
    <subBuilders enabled="true" id="StudioBuilder" name="StudioBuilder">
      <subBuilders enabled="true" hasBuilderForCurrentNode="true" id="VersataStudioRepoBuilder" name="VersataStudioRepoBuilder" deltaVisitor="VersataModelsVisitor"/>
      <subBuilders enabled="true" hasBuilderForCurrentNode="true" id="ClientAppFilesExportBuilder" name="ClientAppFilesExportBuilder" deltaVisitor="ClientAppFilesExportVisitor"/>
    </subBuilders>
    <subBuilders enabled="true" id="JSFBuilder" name="JSFBuilder">
      <subBuilders enabled="true" hasBuilderForCurrentNode="true" id="JSFApplicationBuilder" name="JSFApplicationBuilder" deltaVisitor="JSFApplicationVisitor"/>
      <subBuilders enabled="true" hasBuilderForCurrentNode="true" id="JspPageBuilder" name="JspPageBuilder" deltaVisitor="JSFApplicationVisitor"/>
      <subBuilders enabled="true" hasBuilderForCurrentNode="true" id="JSFClientMetaDataBuilder" name="JSFClientMetaDataBuilder" deltaVisitor="JSFClientMetaDataVisitor"/>
    </subBuilders>
  </builderNode>
  <deltaVisitors id="ClientAppFilesExportVisitor"/>
  <deltaVisitors id="JSFApplicationVisitor"/>
  <deltaVisitors id="JSFClientMetaDataVisitor"/>
  <deltaVisitors id="VersataModelsVisitor"/>
  <deltaVisitors id="VersataModelValidationVisitor"/>
  <deltaVisitors id="VersataServicesVisitor"/>
</builderextension:Builder>
