<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:saxon="http://icl.com/saxon"
                xmlns:lxslt="http://xml.apache.org/xslt"
                xmlns:xalanredirect="org.apache.xalan.xslt.extensions.Redirect"
                xmlns:doc="http://nwalsh.com/xsl/documentation/1.0"
		version="1.1"
                exclude-result-prefixes="doc"
                extension-element-prefixes="saxon xalanredirect lxslt">

<xsl:import href="../../../lib/docbook-xsl/html/docbook.xsl"/>
<xsl:import href="toc.xsl"/>
<xsl:import href="xslutils.xsl"/>
<xsl:import href="documentation.xsl"/>
<xsl:import href="project_plan.xsl"/>

<xsl:template name="article.titlepage.separator"/>
<xsl:param name="generate.section.toc.level" select="0"/>
<xsl:param name="toc.section.depth">2</xsl:param>
<xsl:param name="ulink.target">content</xsl:param>

<xsl:param name="current.date" select="'01.01.2001'"/>
<xsl:param name="output.dir" select="'./'"/>

<xsl:output method="html"
		    encoding="ISO-8859-1"
            indent="yes"/>

<xsl:template match="/">
	<xsl:apply-templates/>
</xsl:template>

<xsl:template match="project-site-index">
	<html>
	<head>
	<title><xsl:value-of select="@title"/></title>
	</head>
	<frameset rows="30,*" framespacing="0">
		<frame name="toc" src="toc.html" frameborder="0" marginheight="0" marginwidth="0" scrolling="no"/>
		<frame name="content" src="main.html" frameborder="0" marginheight="0" marginwidth="2"/>
	</frameset>
	</html>

	<xsl:apply-templates mode="index"/>

	<xsl:call-template name="generate-toc-frame">
		<xsl:with-param name="toc-file" select="'toc.html'"/>
 	</xsl:call-template>
</xsl:template>

<!-- the main page section -->
<xsl:template match="main|main-menu|doc-topic|use-case-item|plan-topic" mode="index">
	<xsl:variable name="file-name">
		<xsl:call-template name="generate-file-name">
			<xsl:with-param name="inFile" select="@href"/>
		</xsl:call-template>
	</xsl:variable>
	<xsl:document href="{concat($output.dir,$file-name)}">
		<link rel="stylesheet" href="./css/content.css"/>
		<html>
		<body>
		<xsl:for-each select="document(@href)">
					<xsl:apply-templates/> 
		</xsl:for-each>
		</body>
		</html>
	</xsl:document>
	<xsl:apply-templates mode="index"/>
</xsl:template>

<xsl:template match="use-case-list" mode="index">
	<xsl:apply-templates mode="index"/>
</xsl:template>

</xsl:stylesheet>	
