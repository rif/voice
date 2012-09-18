<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		version="1.1">

<xsl:import href="use_case.xsl"/>
<xsl:import href="crc.xsl"/>

<xsl:template match="documentation">
	<xsl:apply-templates mode="index"/>
	
	<h2>Documentation</h2>
	<dl>
	<xsl:apply-templates/>
	</dl>
</xsl:template>

<xsl:template match="doc-topic">
	<dt>
	<xsl:choose>
		<xsl:when test="@href!=''">
		<xsl:variable name="file-name">
			<xsl:call-template name="generate-file-name">
				<xsl:with-param name="inFile" select="@href"/>
			</xsl:call-template>
 		</xsl:variable>
			<a>
				<xsl:attribute name="href"><xsl:value-of select="$file-name"/></xsl:attribute>
				<xsl:attribute name="target">content</xsl:attribute>
				<xsl:if test="document(@href)/crc/@name != ''">
					<xsl:value-of select="document(@href)/crc/@name"/>
				</xsl:if>
				<xsl:if test="document(@href)/article/title != ''">
					<xsl:value-of select="document(@href)/article/title"/>
				</xsl:if>
			</a> 
		</xsl:when>
		<xsl:otherwise>
			<xsl:value-of select="@title"/>
		</xsl:otherwise>
	</xsl:choose>
	</dt>
	<dd>
	<dl>
	<xsl:apply-templates/>
	</dl>
	</dd>
</xsl:template>

<xsl:template match="use-case-list">
	<xsl:variable name="uc.level.file">./uc_level.html</xsl:variable>
	<dt>
		Use Cases 
		<a>
			<xsl:attribute name="href"><xsl:value-of select="$uc.level.file"/></xsl:attribute>
			<xsl:attribute name="target">content</xsl:attribute>
			(UCs by level)
		</a>
		<xsl:call-template name="uc-level">
			<xsl:with-param name="output.file" select="$uc.level.file"/>
		</xsl:call-template>
	</dt>
	<dd>
	<dl>
	<xsl:apply-templates/>
	</dl>
	</dd>
</xsl:template>

<xsl:template match="use-case-item">
	<xsl:variable name="file-name">
		<xsl:call-template name="generate-file-name">
			<xsl:with-param name="inFile" select="@href"/>
		</xsl:call-template>
	</xsl:variable>
	<dt>
		<a>
			<xsl:attribute name="href"><xsl:value-of select="$file-name"/></xsl:attribute>
			<xsl:attribute name="target">content</xsl:attribute>
			<xsl:value-of select="document(@href)/use-case/@title"/>
		</a>

		(<xsl:value-of select="document(@href)/use-case/primary-actor"/>)
	</dt>
</xsl:template>

<!-- generate a document with link to all UCs ordered by level -->
<xsl:template name="uc-level">
	<xsl:param name="output.file" select="'./uc_level.html'"/>
	<xsl:document href="{concat($output.dir,$output.file)}">
		<link rel="stylesheet" href="./css/content.css"/>
		<html>
		<body>

		<b>Summary</b>
		<xsl:apply-templates select="use-case-item[document(@href)/use-case/@level = 'summary']"/>
		<br/>

		<b>User Goal</b>
		<xsl:apply-templates select="use-case-item[document(@href)/use-case/@level = 'user-goal']"/>
		<br/>

		<b>Sub Function</b>
		<xsl:apply-templates select="use-case-item[document(@href)/use-case/@level = 'sub-function']"/>		
		<br/>

		</body>
		</html>
	</xsl:document>	
</xsl:template>

</xsl:stylesheet>
