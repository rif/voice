<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		version="1.1">

<xsl:template match="iteration">
	<h2>
		<xsl:value-of select="./period/@start"/> - <xsl:value-of select="./period/@end"/>
		&#160;&#160;(
		<xsl:choose>
			<xsl:when test="@inprogress = 'yes'">
				in progress
			</xsl:when>
			<xsl:when test="@draft = 'yes'">
				draft
			</xsl:when>
			<xsl:otherwise>
				completed
			</xsl:otherwise>
		</xsl:choose>
		)
	</h2>
	<xsl:apply-templates/>
</xsl:template>

<xsl:template match="period"/>

<xsl:template match="cvs-tag">
	<p>
		<xsl:call-template name="create-iteration-topic">
			<xsl:with-param name="topic">CVS Tag</xsl:with-param>
		</xsl:call-template>
		<xsl:apply-templates/>		
	</p>
</xsl:template>

<xsl:template match="goals">
		<p>
		<xsl:call-template name="create-iteration-topic">
			<xsl:with-param name="topic">Goals</xsl:with-param>
		</xsl:call-template>	
		</p>
		<xsl:apply-templates/>		
</xsl:template>

<xsl:template match="accomplishments">
		<xsl:variable name="text">
			<xsl:apply-templates/>		
		</xsl:variable>
		<xsl:if test= "$text!=''">
		<p>
		<xsl:call-template name="create-iteration-topic">
			<xsl:with-param name="topic">Accomplishements</xsl:with-param>
		</xsl:call-template>	
		</p>
		<xsl:apply-templates/>		
		</xsl:if>
</xsl:template>

<xsl:template match="postponed-goals">
		<p>
		<xsl:call-template name="create-iteration-topic">
			<xsl:with-param name="topic">Postponed Goals</xsl:with-param>
		</xsl:call-template>	
		</p>
		<xsl:apply-templates/>
</xsl:template>

<xsl:template match="incomplete-goals">
		<p>
		<xsl:call-template name="create-iteration-topic">
			<xsl:with-param name="topic">Incomplete Goals</xsl:with-param>
		</xsl:call-template>	
		</p>
		<xsl:apply-templates/>
</xsl:template>

<xsl:template match="notes">
		<p>
		<xsl:call-template name="create-iteration-topic">
			<xsl:with-param name="topic">Notes</xsl:with-param>
		</xsl:call-template>	
		</p>
		<xsl:apply-templates/>
</xsl:template>


<xsl:template name="create-iteration-topic">
	<xsl:param name="topic"/>
	<b><xsl:value-of select="$topic"/>: </b>
</xsl:template>

</xsl:stylesheet>
