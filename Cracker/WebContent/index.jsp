<%@ include file="includes/header.jsp" %>

<div class="animated bounceInDown" style="font-size:48pt; font-family:arial; color:#990000; font-weight:bold">Vigenere Cypher Breaker</div>

</p>&nbsp;</p>&nbsp;</p>

<table width="600" cellspacing="0" cellpadding="7" border="0">
	<tr>
		<td valign="top">

			<form bgcolor="white" method="POST" action="doProcess">
				<fieldset>
					<legend><h3>Cypher Details</h3></legend>
					
					<b>Servant IP (Leave blank if run locally): <input name="frmServantIP" type="text" size="14">
					<p/>				
					<b>Maximum Vigenere Key Length: <input name="frmMaxKeyLength" type="text" size="2" value="5">
					<p/>

					<b>Enter Cypher-Text:</b><br>
					<textarea name="frmCypherText" rows="10" cols="100" value="VRPEKRNVDJSFWFUCYHYNWRRWEQNQXPCGEEGKVXAUCHEZWWA"  wrap="soft"></textarea>	
					<p/>


					<center><input type="submit" value="Crack Cypher"></center>
				</fieldset>							
			</form>	

		</td>
	</tr>
</table>

<%@ include file="includes/footer.jsp" %>

