<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		version="1.1">

<xsl:template name="generate-file-name">
	<xsl:param name="inFile" select="''"/>
	<xsl:value-of select="concat(substring-before($inFile,'.xml'), '.html')"/>
</xsl:template>
</xsl:stylesheet>