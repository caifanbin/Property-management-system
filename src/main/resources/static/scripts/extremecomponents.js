function getParameterMap(form) {
    var p = document.forms[form].elements;
    var map = new Object();
    for(var x=0; x < p.length; x++) {
        var key = p[x].name;
        var val = p[x].value;
        
        //Check if this field name is unique.
        //If the field name is repeated more than once
        //add it to the current array.
        var curVal = map[key]; 
        if (curVal) { // more than one field so append value to array
        	curVal[curVal.length] = val;
        } else { // add field and value
        	map[key]= [val];
        }
    }
    return map;
}

function setFormAction(form, action, method) {
	if (action) {
		document.forms[form].setAttribute('action', action);
	}
	
	if (method) {
		document.forms[form].setAttribute('method', method);
	}
	
	document.forms[form].ec_eti.value='';
}

function setTreeStyle(num){
	var defWidth = 20;
	var tables = window.document.getElementsByTagName("table");
	
	//table[2].rows[0].cells[1].rowSpan = 2;
	var firstRow = tables[num].rows[0];
	firstRow.innerHTML.replace("<td>"+firstRow.cells[1].innerHTML+"</td>",
	"<td rowspan=2>"+firstRow.cells[1].innerHTML+"</td>");
	
	firstRow.cells[0].style.width=defWidth;

	for(var i = num+1; i < tables.length; i++){
		tables[i].rows[0].cells[0].style.width=defWidth;
		tables[i].rows[0].cells[1].style.width=defWidth;
	}
}
