<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		version="1.1">
<!-- the table of contents frame -->
<xsl:template name="generate-toc-frame">
	<xsl:param name="toc-file" select="'toc.html'"/>
	<xsl:document href="{concat($output.dir,$toc-file)}">
		<link rel="stylesheet" href="./css/toc.css"/>
		<html><body>
		<table height="100%" width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
		<xsl:apply-templates select="/project-site-index/child::*" mode="table-of-contents"/>	
		</tr>
		</table>
		</body></html>
	</xsl:document>
</xsl:template>

<xsl:template match="main|main-menu" mode="table-of-contents">
	<xsl:variable name="file-name">
		<xsl:call-template name="generate-file-name">
			<xsl:with-param name="inFile" select="@href"/>
		</xsl:call-template>
 	</xsl:variable>			
	<td valign="center" class="firstLevelLink" width="100">
	<a>
		<xsl:attribute name="href"><xsl:value-of select="$file-name"/></xsl:attribute>
		<xsl:attribute name="target">content</xsl:attribute>
		<xsl:value-of select="@title"/>
	</a>
	</td>
</xsl:template>

</xsl:stylesheet>