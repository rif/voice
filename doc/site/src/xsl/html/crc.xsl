<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		version="1.1">

<xsl:template match="crc">
	<table border="1">
		<tr>
			<td colspan="2" class="crcName">
				<p>Class: <xsl:value-of select="@name"/></p>
			</td>
		</tr>

		<tr>
			<td class="crcResponsibilty">
				<p>Responsibilities:</p>
				<xsl:apply-templates select="responsibility-list"/>
			</td>
	
			<td class="crcCollaboration">
				<p>Collaborations:</p>
				<xsl:apply-templates select="collaboration-list"/>
			</td>
		</tr>
	</table>	
</xsl:template>

<xsl:template match="responsibility-list">
	<ul>
		<xsl:apply-templates/>
	</ul>
</xsl:template>

<xsl:template match="responsibility">
	<li>
		<p><xsl:apply-templates select="text()"/></p>
	</li>
</xsl:template>


<xsl:template match="collaboration-list">
	<ul>
	<xsl:apply-templates/>
	</ul>
</xsl:template>

<xsl:template match="collaboration">
	<xsl:variable name="file-name">
		<xsl:call-template name="generate-file-name">
			<xsl:with-param name="inFile" select="@href"/>
		</xsl:call-template>
	</xsl:variable>
	<li>
	<p>
	<a>
		<xsl:attribute name="href"><xsl:value-of select="$file-name"/></xsl:attribute>
		<xsl:attribute name="target">content</xsl:attribute>
		<xsl:value-of select="document(@href)/crc/@name"/>
	</a>
	</p>
	</li>
</xsl:template>



</xsl:stylesheet>
