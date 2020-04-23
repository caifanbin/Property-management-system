var clientX;
var clientY;

function showAlertInfo(event,url){
    clientX = event.clientX;
    clientY = event.clientY;    
    var myAjax = new Ajax.Request(       
        url,       
        {       
        method:"post",     
        onComplete:alertComplete,
        asynchronous:true      
        }       
    );
}

function alertComplete(request) {
	alertStr(request.responseText);
	if(document.getElementById("msgDiv")){
	    //ID = window.setTimeout("removeAlertStr();",10000);
	}
}

function alertStr(str){
    
    var msgObj=document.createElement("div")
	msgObj.setAttribute("id","msgDiv");
	msgObj.setAttribute("align","left");
	msgObj.style.background="#ffffe1";
	msgObj.style.border="1px solid #000000";
	msgObj.style.position = "absolute";
	msgObj.style.left = 20 + clientX;
	msgObj.style.top = 12 + clientY;
	msgObj.style.font="12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
	msgObj.style.textAlign = "left";
	msgObj.style.lineHeight ="12px";
	msgObj.style.zIndex = "10001"; 
	document.body.appendChild(msgObj); 
	
	var txt=document.createElement("p");
	txt.style.margin="1px 0"
	txt.setAttribute("id","msgTxt");
	txt.innerHTML=str;
    document.getElementById("msgDiv").appendChild(txt); 
    
}

function removeAlertStr(){
	 var msgTxt = document.getElementById("msgTxt");
	 var msgDiv = document.getElementById("msgDiv"); 
	 if(msgTxt && msgDiv){
	    document.getElementById("msgDiv").removeChild(msgTxt);
	 }
	 if(msgDiv){
	    document.body.removeChild(msgDiv);
	 }
}