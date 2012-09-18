<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		version="1.1">

<xsl:template match="use-case">
	<h2><xsl:value-of select="@title"/></h2>	
	<xsl:apply-templates select="primary-actor|goal|scope"/>
	<xsl:apply-templates select="@level"/>
	<xsl:apply-templates/>
</xsl:template>

<xsl:template match="primary-actor">
	<p>
		<xsl:call-template name="create-use-case-topic">
			<xsl:with-param name="topic">Primary Actor</xsl:with-param>
		</xsl:call-template>
		<xsl:apply-templates/>
	</p>
</xsl:template>

<xsl:template match="goal">
	<p>
		<xsl:call-template name="create-use-case-topic">
			<xsl:with-param name="topic">Goal</xsl:with-param>
		</xsl:call-template>
		<xsl:apply-templates/>
	</p>
</xsl:template>

<xsl:template match="scope">
	<p>
		<xsl:call-template name="create-use-case-topic">
			<xsl:with-param name="topic">Scope</xsl:with-param>
		</xsl:call-template>
		<xsl:apply-templates/>
	</p>
</xsl:template>

<xsl:template match="@level">
	<p>
		<xsl:call-template name="create-use-case-topic">
			<xsl:with-param name="topic">Level</xsl:with-param>
		</xsl:call-template>
		<xsl:choose>
			<xsl:when test=". = 'summary'">
				Summary
			</xsl:when>
			<xsl:when test=". = 'user-goal'">
				User Goal
			</xsl:when>
			<xsl:when test=". = 'sub-function'">
				Sub Function
			</xsl:when>
			<xsl:otherwise>
				Not Recognized(<xsl:value-of select="."/>)
			</xsl:otherwise>
		</xsl:choose>
	</p>
</xsl:template>

<xsl:template match="precondition">
	<p>
		<xsl:call-template name="create-use-case-topic">
			<xsl:with-param name="topic">Precondition</xsl:with-param>
		</xsl:call-template>
		<xsl:apply-templates/>
	</p>
</xsl:template>

<xsl:template match="minimal-guarantees">
	<p>
		<xsl:call-template name="create-use-case-topic">
			<xsl:with-param name="topic">Minimal Guarantees</xsl:with-param>
		</xsl:call-template>
		<xsl:apply-templates/>
	</p>
</xsl:template>

<xsl:template match="success-guarantees">
	<p>
		<xsl:call-template name="create-use-case-topic">
			<xsl:with-param name="topic">Success Guarantees</xsl:with-param>
		</xsl:call-template>
		<xsl:apply-templates/>
	</p>
</xsl:template>

<xsl:template match="trigger">
	<p>
		<xsl:call-template name="create-use-case-topic">
			<xsl:with-param name="topic">Trigger</xsl:with-param>
		</xsl:call-template>
		<xsl:apply-templates/>
	</p>
</xsl:template>

<xsl:template match="scenario">
	<p>
		<xsl:call-template name="create-use-case-topic">
			<xsl:with-param name="topic">Scenario</xsl:with-param>
		</xsl:call-template>
		<br/>
		<!--xsl:apply-templates select="text()"/-->
		<xsl:apply-templates select="step"/>
	</p>
	<xsl:variable name="extensions">
		<xsl:apply-templates select="step" mode="extensions"/>
	</xsl:variable>
	<xsl:if test= "$extensions!=''">
		<p>
		<xsl:call-template name="create-use-case-topic">
			<xsl:with-param name="topic">Extensions</xsl:with-param>
		</xsl:call-template>
		<br/>
		<xsl:apply-templates select="step" mode="extensions"/>
		</p>
	</xsl:if>
</xsl:template>

<xsl:template match="step">
	<xsl:value-of select="position()"/>. <xsl:apply-templates/> <br/>
</xsl:template>

<xsl:template match="uc-include">
	<xsl:variable name="file-name">
		<xsl:call-template name="generate-file-name">
			<xsl:with-param name="inFile" select="@href"/>
		</xsl:call-template>
	</xsl:variable>
	<a>
		<xsl:attribute name="href"><xsl:value-of select="$file-name"/></xsl:attribute>
		<xsl:attribute name="target">content</xsl:attribute>
		<xsl:apply-templates select="text()"/>
	</a>
</xsl:template>

<xsl:template match="extension-step">
</xsl:template>

<xsl:template match="step" mode="extensions">
	<xsl:apply-templates select="extension-step" mode="extensions">
		<xsl:with-param name="current-counter"><xsl:value-of select="position()"/></xsl:with-param>	
	</xsl:apply-templates>
</xsl:template>

<xsl:template match="extension-step" mode="extensions">
	<xsl:param
		name="current-counter"
		select="0">
	</xsl:param>
	<xsl:param
		name="current-indent"
		select="''">
	</xsl:param>

	<xsl:variable name="new-counter">
		<xsl:value-of select="concat(concat($current-counter, '.'), position())"/>
	</xsl:variable>
	<xsl:variable name="new-indent">
		<xsl:value-of select="concat($current-indent, '&#160;&#160;')"/>
	</xsl:variable>

	<xsl:value-of select="$current-indent"/>
	<xsl:value-of select="$new-counter"/>.
	<xsl:apply-templates select="text()"/>
	<br/>

	<xsl:apply-templates select="extension-step" mode="extensions">
		<xsl:with-param name="current-counter"><xsl:value-of select="$new-counter"/></xsl:with-param>	
		<xsl:with-param name="current-indent"><xsl:value-of select="$new-indent"/></xsl:with-param>	
	</xsl:apply-templates>

</xsl:template>

<xsl:template match="open-issues">
	<p>
		<xsl:call-template name="create-use-case-topic">
			<xsl:with-param name="topic">Open Issues</xsl:with-param>
		</xsl:call-template>
		<xsl:apply-templates/>
	</p>
</xsl:template>

<xsl:template name="create-use-case-topic">
	<xsl:param name="topic"/>
	<b><xsl:value-of select="$topic"/>: </b>
</xsl:template>

</xsl:stylesheet>
