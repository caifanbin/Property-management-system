function doExport(){
  bdhtml=window.document.body.innerHTML
  sprnstr="<!--startprint-->"
  eprnstr="<!--endprint-->"
  prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17)
  prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr))
  ExcelSheet = new ActiveXObject('Excel.Application');
  var wlexport=window.open("","wlexport","left=0,top=0,height=600,width=800,toolbar=yes,resizable=yes,status=no,menubar=yes")
  wlexport.document.write("<link rel=stylesheet type=text/css href=./css/amprint.css>"+prnhtml)
  wlexport.document.close()
  ExcelSheet.Application.Visible = true;
  var mywork=ExcelSheet.workbooks.add;
  var mydoc=mywork.sheets.add(mywork.worksheets(1));
  var sel=wlexport.document.body.createTextRange();
  //var myData= new GetTableData(bdhtml,0,0);
  sel.select();
  wlexport.document.execCommand('Copy');
  sel.moveEnd('character');
  wlexport.close();
  mydoc.paste();
  mydoc.usedrange.Hyperlinks.DELETE();
  mydoc.Rows('1:1').Font.Name = "\u5B8B\u4F53";  //
  mydoc.Rows('1:1').Font.Color = (15,16,27); 
  mydoc.Rows('1:1').Font.Size = 14;  
  mydoc.Rows('1:1').HorizontalAlignment = 3;
  mydoc.Rows('1:1').Font.Bold = true; 
  mydoc.Rows(''+mydoc.UsedRange.Rows.Count+':2').Font.Size = 12;  
  mydoc.Rows(''+mydoc.UsedRange.Rows.Count+':2').HorizontalAlignment = 4;
  mydoc.Columns('A:A').HorizontalAlignment = 2;
  mydoc.Columns('A:A').ColumnWidth = 62;
  //mydoc.Rows('4:'+(4+mydoc.rows-1)).Font.Size = 12;  
  mydoc.usedrange.borders.linestyle=1;
  mydoc.usedrange.borders.weight=2;
  mydoc.usedrange.borders.colorindex=-4105;
  mydoc.usedrange.WrapText=true;
  //doExportFormat(mydoc.columns, mydoc.rows);
  mydoc.usedrange.columns.AutoFit();
}

function doExportList(){
  bdhtml=window.document.body.innerHTML
  sprnstr="<!--startprint-->"
  eprnstr="<!--endprint-->"
  prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17)
  prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr))
  ExcelSheet = new ActiveXObject('Excel.Application');
  var wlexport=window.open("","wlexport","left=0,top=0,height=600,width=800,toolbar=yes,resizable=yes,status=no,menubar=yes")
  wlexport.document.write("<link rel=stylesheet type=text/css href=./css/amprint.css>"+prnhtml)
  wlexport.document.close()
  ExcelSheet.Application.Visible = true;
  var mywork=ExcelSheet.workbooks.add;
  var mydoc=mywork.sheets.add(mywork.worksheets(1));
  var sel=wlexport.document.body.createTextRange();
  //var myData= new GetTableData(bdhtml,0,0);
  sel.select();
  wlexport.document.execCommand('Copy');
  sel.moveEnd('character');
  wlexport.close();
  mydoc.paste();
  mydoc.usedrange.Hyperlinks.DELETE();
  mydoc.Rows(''+mydoc.UsedRange.Rows.Count+':1').Font.Size= 12;  
  //mydoc.Rows('4:'+(4+mydoc.rows-1)).Font.Size = 12;  
  mydoc.usedrange.borders.linestyle=1;
  mydoc.usedrange.borders.weight=2;
  mydoc.usedrange.borders.colorindex=-4105;
  mydoc.usedrange.WrapText=false;
  //doExportFormat(mydoc.columns, mydoc.rows);
  mydoc.usedrange.columns.AutoFit();
  //mydoc.Rows(''+mydoc.UsedRange.Rows.Count+':1').ColumnWidth = 20;  
    var i;
    var j=mydoc.UsedRange.Columns.Count;
    var str="";
    for(i = 1; i <= j; i=i+1){
    	if(mydoc.UsedRange.Columns(i).ColumnWidth > 20 ){
	    //alert(mydoc.UsedRange.Columns(i).ColumnWidth);
	    	str=''+i.toString()+':'+i.toString()+'';
	    	//alert(str);  	
	  		mydoc.Columns(str).ColumnWidth = 20;     
		}
	}
    mydoc.usedrange.WrapText = true;
    mydoc.usedrange.Rows.AutoFit();
}

function doPrint(){
  bdhtml=window.document.body.innerHTML
  sprnstr="<!--startprint-->"
  eprnstr="<!--endprint-->"
  prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17)
  prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr))
  wlprint=window.open("","wlprint","left=0,top=0,height=600,width=800,toolbar=yes,resizable=yes,status=no,menubar=yes")
  wlprint.document.write("<link rel=stylesheet type=text/css href=./css/amprint.css>"+prnhtml)
  wlprint.document.close();
  wlprint.print();
  wlprint.close();
}


function doExportFormat(columns, rows){
  bdhtml=window.document.body.innerHTML
  sprnstr="<!--startprint-->"
  eprnstr="<!--endprint-->"
  prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17)
  prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr))
  ExcelSheet = new ActiveXObject('Excel.Application');
  var wlexport=window.open("","wlexport","left=0,top=0,height=600,width=800,toolbar=yes,resizable=yes,status=no,menubar=yes")
  wlexport.document.write("<link rel=stylesheet type=text/css href=./css/amprint.css>"+prnhtml)
  wlexport.document.close()
  
  var mywork=ExcelSheet.workbooks.add;
  var mydoc=mywork.ActiveSheet;
  var sel=wlexport.document.body.createTextRange();
  sel.select();
  wlexport.document.execCommand('Copy');
  sel.moveEnd('character');
  wlexport.close();
  mydoc.paste();
  mydoc.Columns('A:A').ColumnWidth  = 2;
  mydoc.Columns('B:B').ColumnWidth  = 10;
  mydoc.Columns('C:C').ColumnWidth  = 10;
  mydoc.Columns('D:D').ColumnWidth  = 20;
  mydoc.Columns('E:E').ColumnWidth  = 6;
  mydoc.Columns('F:F').ColumnWidth  = 6;
  mydoc.Columns('G:G').ColumnWidth  = 6;
  mydoc.Columns('H:H').ColumnWidth  = 6;
  mydoc.Columns('I:I').ColumnWidth  = 8;
  mydoc.Columns('J:J').ColumnWidth  = 14;
  mydoc.Columns('K:K').ColumnWidth  = 20;
  mydoc.Columns('L:L').ColumnWidth  = 5;
  mydoc.Columns('M:M').ColumnWidth  = 10;
  mydoc.Columns('N:N').ColumnWidth  = 8;
  
  mydoc.Columns('B:B').Font.Underline = false;  
  
  mydoc.Rows('1:1').Font.Name = "\u5B8B\u4F53";  //å®ä½
  mydoc.Rows('1:1').Font.Color = (15,16,27); 
  mydoc.Rows('1:1').Font.Size = 22;  
  mydoc.Rows('1:1').Font.Bold = true; 
  mydoc.Rows('1:1').HorizontalAlignment = -4108;
  mydoc.Rows('1:1').VerticalAlignment = -4108;  
  
  mydoc.Rows('2:3').Font.Name = "\u9ED1\u4F53";//é»ä½
  mydoc.Rows('2:3').Font.Color = (15,16,27); 
  mydoc.Rows('2:3').Font.Size = 8;  
  mydoc.Rows('2:3').Font.Bold = true; 
  mydoc.Rows('2:3').HorizontalAlignment = -4108;
  mydoc.Rows('2:3').VerticalAlignment = -4108;  
  
  mydoc.Rows('4:'+(4+rows-1)).Font.Name = "\u5B8B\u4F53";//å®ä½
  mydoc.Rows('4:'+(4+rows-1)).Font.Color = (15,16,27); 
  mydoc.Rows('4:'+(4+rows-1)).Font.Size = 8;  
  ExcelSheet.Application.Visible = true;
}
