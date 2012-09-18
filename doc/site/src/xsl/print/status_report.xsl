<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		version="1.1">

<xsl:output method="xml"
	    indent="yes"
	    encoding="ISO-8859-1"/>

<!-- from project_plan.xml -->
<xsl:template match="/status">
	      <xsl:apply-templates select="project-plan"/>
</xsl:template>

<xsl:template match="project-plan">
	      <xsl:apply-templates select="plan-topic[not(document(@href)/iteration/@inprogress or document(@href)/iteration/@draft)][position()=1]"/>
</xsl:template>


<xsl:template match="plan-topic">
      <article>
      <title>Status Report</title>
            <xsl:apply-templates select="document(@href)"/>
      </article>
</xsl:template>

<xsl:template match="iteration">
		<xsl:call-template name="create-iteration-topic">
			<xsl:with-param name="topic">Incomplete Goals</xsl:with-param>
		</xsl:call-template>
</xsl:template>

<xsl:template match="period|cvs-tag"/>

<xsl:template match="goals">
		<xsl:call-template name="create-iteration-topic">
			<xsl:with-param name="topic">Goals</xsl:with-param>
		</xsl:call-template>
</xsl:template>

<xsl:template match="accomplishments">
		<xsl:call-template name="create-iteration-topic">
			<xsl:with-param name="topic">Accomplishments</xsl:with-param>
		</xsl:call-template>
</xsl:template>

<xsl:template match="incomplete-goals">
		<xsl:call-template name="create-iteration-topic">
			<xsl:with-param name="topic">Incomplete Goals</xsl:with-param>
		</xsl:call-template>
</xsl:template>
<xsl:template match="postponed-goals">
		<xsl:call-template name="create-iteration-topic">
			<xsl:with-param name="topic">Postponed Goals</xsl:with-param>
		</xsl:call-template>
</xsl:template>
<xsl:template match="notes">
		<xsl:call-template name="create-iteration-topic">
			<xsl:with-param name="topic">Notes</xsl:with-param>
		</xsl:call-template>
</xsl:template>

<xsl:template match="@*|node()">
<xsl:copy>
<xsl:apply-templates select="@*|node()"/>
</xsl:copy>
</xsl:template>

<xsl:template name="create-iteration-topic">
	<xsl:param name="topic"/>
	<section>
	<title><xsl:value-of select="$topic"/></title>
	<xsl:apply-templates/>
	</section>
</xsl:template>

</xsl:stylesheet>
