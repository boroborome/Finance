/**
 * 
 */
goog.provide("com.boroborome.finance");
function appendRecord2Table(record)
{
}
function loadFinanceData()
{
	$.post("/agent/finance.query",
    {
      name:"Donald Duck",
      city:"Duckburg"
    },
    function(data,status)
    {
    	if (data.charAt(0) != '\"')
    	{
    		alert(data);
    		return;
    	}
    	// var aryRecord = JSON.parse(data);
    	var aryRecord = data.evalJSON(true);
    	for (index = 0, size = aryRecord.length;index < size; ++index)
    	{
    		var record = aryRecord[index];
    		var rowData = "<tr><td>" + record.date + "</td><td>"
    			+ record.wares + "</td></tr>";
    		$("#tblFinance").append(rowData);
    	}
 
    });
    
}
$(document).ready(function()
{
	$("#btnAdd").click(function()
	{
		$("#dlgFinanceInfo").dialog("open");
	});
	$("#btnModify").click(function()
	{
  
	});
	$("#btnDelete").click(function(){
  
	});
	$("#btnQuery").click(function(){
		loadFinanceData();
	});
  

    $("#dlgFinanceInfo").dialog({
		autoOpen: false,
		width:400,
		dialogClass: "no-close",
		buttons: [
		          {
		        	  text: "OK",
		        	  click: function(){$(this).btnOK();}
		          }]
    });
	  
    addDlg.btnOK=function()  
    {
    	// collect all information
       	var info = {
       		consumeTime:$("#addDlgConsumeDate").val(),
       		waresName:$("#addDlgWareName").val()
       		};
       	info.price=$("#addDlgPrice").val();
       	info.unit=$("#addDlgUnit").val();
       	info.deadline=$("#addDlgDeadline").val();
       	info.kind=$("#addDlgKind").val();
       	info.remark=$("#addDlgRemark").val();
       	
       	// send information to the server
       	$.post("/agent/finance.add", info, msgReceved);
	},
	addDlg.msgReceved=function(data, status)
    {
    	if (data.charAt(0) != '\"')
    	{
    		updateTip(data);
    		return;
    	}
    	
    	// if the server save it success the show this record in table
    	var record = data.evalJSON(true);
    	appendRecord2Table(record);
        $( this ).dialog( "close" );
    },
    addDlg.tips=$("#validateTips"),
    
    addDlg.updateTip=function(msg)
    {
    	tips.text( t )
			.addClass( "ui-state-highlight" );
		setTimeout(function() {
			tips.removeClass( "ui-state-highlight", 1500 );
		}, 500 );
    }
    
    $("#addDlgConsumeDate").datepicker({dateFormat: "yy-mm-dd"});
});
