<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		version="1.1">

<xsl:import href="iteration.xsl"/>

<xsl:template match="status">
	      <xsl:apply-templates/>
</xsl:template>

<xsl:template match="project-plan">
	<xsl:apply-templates mode="index"/>
	
	<h2>Iterations</h2>
	<dl>
	<xsl:apply-templates/>
	</dl>
</xsl:template>

<xsl:template match="release">
	<xsl:variable name="file-name">
		<xsl:value-of select="concat('release',position(),'.html')"/>
	</xsl:variable>
	<xsl:variable name="start">
		<xsl:value-of select="document(./plan-topic[last()]/@href)/iteration/period/@start"/>
	</xsl:variable>
	<xsl:variable name="end">
		<xsl:value-of select="document(./plan-topic[position()=1]/@href)/iteration/period/@end"/>
	</xsl:variable>
	<xsl:variable name="cvs-tag">
		<xsl:value-of select="document(./plan-topic[position()=1]/@href)/iteration/cvs-tag"/>
	</xsl:variable>

	<a>
		<xsl:attribute name="href"><xsl:value-of select="$file-name"/></xsl:attribute>
		<xsl:attribute name="target">content</xsl:attribute>
		<b><xsl:value-of select="@name"/></b> -> 
		<xsl:value-of select="$start"/> - <b><xsl:value-of select="$end"/></b>
	</a>
	<dl>

	<!-- generate the release file -->
	<xsl:document href="{concat($output.dir,$file-name)}">
		<link rel="stylesheet" href="./css/content.css"/>
		<html>
		<body>
		<h2>
			<xsl:value-of select="@name"/>
			(
			<xsl:value-of select="$start"/>
			- 
			<xsl:value-of select="$end"/>
			)
		</h2>
		<p>
			<b>CVS Tag: </b>
			<xsl:value-of select="$cvs-tag"/>
		</p>
		<p>
			<b>Goals: </b>
		</p>
		<p>
			<xsl:for-each select="document(./plan-topic/@href)">
				<xsl:apply-templates select="/iteration/goals/*"/>
			</xsl:for-each>
		</p>
		</body>
		</html>
	</xsl:document>

	<xsl:apply-templates/>
	</dl>
</xsl:template>

<xsl:template match="plan-topic">
	<dt>
			<xsl:variable name="file-name">
				<xsl:call-template name="generate-file-name">
					<xsl:with-param name="inFile" select="@href"/>
				</xsl:call-template>
	 		</xsl:variable>
			<a>
				<xsl:attribute name="href"><xsl:value-of select="$file-name"/></xsl:attribute>
				<xsl:attribute name="target">content</xsl:attribute>
				<xsl:value-of select="document(@href)/iteration/period/@start"/>
				- <xsl:value-of select="document(@href)/iteration/period/@end"/>
				&#160;&#160;(
				<xsl:choose>
					<xsl:when test="document(@href)/iteration/@inprogress = 'yes'">
						in progress
					</xsl:when>
					<xsl:when test="document(@href)/iteration/@draft = 'yes'">
						draft
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="document(@href)/iteration/cvs-tag"/>
					</xsl:otherwise>
				</xsl:choose>
				)
			</a>
	</dt>
	<dd>
	<dl>
	<xsl:apply-templates/>
	</dl>
	</dd>
</xsl:template>

<xsl:template match="cvs">
	<p>
	<a>
	<xsl:attribute name="href"><xsl:value-of select="@href"/></xsl:attribute>
	<xsl:attribute name="target">content</xsl:attribute>
		CVS Sources
	</a>
	</p>
</xsl:template>

<xsl:template match="build-status">
	<p>
	<a>
	<xsl:attribute name="href"><xsl:value-of select="@href"/></xsl:attribute>
	<xsl:attribute name="target">content</xsl:attribute>
		Build Status
	</a>
	</p>
</xsl:template>

</xsl:stylesheet>
