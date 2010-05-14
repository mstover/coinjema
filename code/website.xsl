<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:param name="title"></xsl:param>
	<xsl:param name="menu"></xsl:param>

	<xsl:output method="html" encoding="ISO-8859-1" />


	<xsl:template match="/">
		<html>
			<head>
				<base href="http://mstover.github.com/coinjema/" />
				<link rel="StyleSheet" type="text/css" href="coinjema.css" />
				<link rel="StyleSheet" type="text/css" href="menu.css" />
				<script language="Javascript" src="functions.js" type="text/javascript"></script>
				<title><xsl:value-of select="$title"/></title>
			</head>
			<body>
				<div class="menubar_space_holder" style="width:100%;z-index:0;visibility:hidden">This space left
					intentionally blank</div>
				<div id="menubar" class="menubar"
					style="position:fixed; width:100%; left:0px;top:0px;z-index:2">
					<div class="page-header">
						<span class="title"><xsl:value-of select="$title"/></span>
					</div>
					<xsl:apply-templates select="document($menu)"
						mode="menu"></xsl:apply-templates>
				</div>
				<div class="content">
					<xsl:apply-templates select="xmlContent/*"
						mode="xml_content" />
					<xsl:apply-templates select="webContent/*"
						mode="web_content"></xsl:apply-templates>
				</div>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="/menu/item" mode="menu">
		<div id="{name}_menu" onmouseover="javascript:enterMenu('{name}')"
			onmouseout="javascript:exitMenu('{name}')" class="menuHeader">
			<xsl:choose>
				<xsl:when test="not(url='')">
					<a href="{url}">
						<xsl:value-of select="name"></xsl:value-of>
					</a>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="name"></xsl:value-of>
				</xsl:otherwise>
			</xsl:choose>

		</div>
		<xsl:apply-templates select="menu" mode="popup_menu">
			<xsl:with-param name="parentName" select="name"></xsl:with-param>
		</xsl:apply-templates>

	</xsl:template>

	<xsl:template match="menu" mode="popup_menu">
		<xsl:param name="parentName" required="yes"></xsl:param>
		<div id="{$parentName}" class="menu"
			style="position:fixed; z-index:5;display:none;" onmouseover="javascript:enterMenu('{$parentName}')"
			onmouseout="javascript:exitMenu('{$parentName}')">
			<xsl:for-each select="item">
				<a class="item" href="{url}">
					<xsl:value-of select="name"></xsl:value-of>
				</a>

			</xsl:for-each>
		</div>
	</xsl:template>

	<xsl:template match="@*|node()" mode="web_content">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()" mode="web_content" />
		</xsl:copy>
	</xsl:template>

	<xsl:template match="section" mode="xml_content">
		<blockquote>
			<div class="section_header">
				<xsl:value-of select="./title" />
			</div>
			<xsl:apply-templates select="*[not(name()='title')]"
				mode="xml_content"></xsl:apply-templates>
		</blockquote>
	</xsl:template>

	<xsl:template match="list" mode="xml_content">
		<ol>
			<xsl:apply-templates select="*" mode="xml_content" />
		</ol>
	</xsl:template>

	<xsl:template match="item" mode="xml_content">
		<li>
			<xsl:value-of select="." />
		</li>
	</xsl:template>

	<xsl:template match="text" mode="xml_content">
		<p>
			<xsl:value-of select="." />
		</p>
	</xsl:template>

	<xsl:template match="title" mode="xml_content">
		<h1>
			<xsl:value-of select="."></xsl:value-of>
		</h1>
	</xsl:template>
</xsl:stylesheet>