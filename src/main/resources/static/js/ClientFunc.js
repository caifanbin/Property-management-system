function isNumber(inputVal) {
	oneDecimal = false;
	if(inputVal=="")
	  return false;
	inputStr = inputVal.toString();
	for (var i = 0; i < inputStr.length; i++) {
		var oneChar = inputStr.charAt(i);
		if (i == 0 && oneChar == "-") {
			continue;
		}
		if (oneChar == "." && !oneDecimal) {
			oneDecimal = true;
			continue;
		}
		if (oneChar < "0" || oneChar > "9") {
			return false;
		}
	}
	return true;
}
function isInteger(inputVal){
  if(!isNumber(inputVal)) return false;
  if(inputVal.indexOf(".")>=0) return false;
  else
  return true;
}

function LTrim(s)
{
    for(var i=0;i<s.length;i++)
    {
      if(s.charAt(i)!=" ")
      {
          return s.substr(i,s.length-i);
      }
   }
   return "";
}
function RTrim(s)
{
    for(var i=s.length-1;i>=0;i--)
    {
      if(s.charAt(i)!=" ")
      {
          return s.substr(0,i+1);
      }
   }
   return "";
}
function Trim(s)
{
    return  RTrim(LTrim(s));
}
function isPageNum(inputVal) {
	inputStr = Trim(inputVal.toString());
	for(var i=0;i< inputStr.length;i++) {
		var oneChar = inputStr.charAt(i);
		if (oneChar < "0" || oneChar > "9") {
			return false;
		}
	}
	return true;
}

//????????????????????????????
function isEmpty(s)
{
    return ""==Trim(s);
}

function LTrimZero(s)
{
    for(var i=0;i<s.length;i++)
    {
      if(s.charAt(i)!="0")
      {
          return s.substr(i,s.length-i);
      }
   }
   return "";
}
//????????????????????????
function  isDate(sDate)
{
    if (sDate.length!=10)  return false ;
    var   arrDate = sDate.split("-");
    if (arrDate.length!=3)  return false ;

    var year  = arrDate[0] ;
    var month = arrDate[1] ;
    var day   = arrDate[2] ;

	if( isEmpty(year) || isEmpty(month) || isEmpty(day)) return false;
    if ( isNaN(year) || isNaN(month) || isNaN(day)) return false ;

    year  = parseInt(LTrimZero(year));
    month = parseInt(LTrimZero(month));
    day   = parseInt(LTrimZero(day));

    if ( isNaN(year) || year < 1900 || year>2100 || month > 12 || day > 31 || month<0 || day<0 ) return false ;

    switch(month)
    {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
           return true ;
        case 4:
        case 6:
        case 9:
        case 11:
           if (day>30) return false ;
           return true ;
        case 2 :

           //????
           if (0==year%4 && (year%100)!=0 || 0==year%400)
           {
               if (day>29) return false ;
               return true ;
           }
           //??????
           if (day>28) return false ;
           return true ;
        default:
           return false ;
    }
}

//????????????????????????
function isTime(sTime)
{
	var   arrTime = sTime.split(":");
	var   hour ;
	var   minute ;
	var   second ;

	if (arrTime.length>3)  return false ;

    if(arrTime.length==0)           // just  hour
    {
    	hour = 0;
    	minute=0;
    	second=0;
    }
    if(arrTime.length==1)
    {
    	hour = arrTime[0];
	  	minute=0;
    	second=0;
	}
	if(arrTime.length==2)
    {
    	hour = arrTime[0];
	  	minute=arrTime[1];
    	second=0;
	}
	if(arrTime.length==3)
    {
    	hour = arrTime[0];
	  	minute=arrTime[1];
    	second=arrTime[2];
	}

    if ( isNaN(hour) || isNaN(minute) || isNaN(second)) return false ;

    hour  = parseInt(LTrimZero(hour));
    minute = parseInt(LTrimZero(minute));
    second   = parseInt(LTrimZero(second));

    if( hour<0 || hour>23 || minute<0 || minute>59 || second<0 || second>59)
    {
    	return false; //exit
    }
    return true;
}

function isDateTime(sDateTime)
{
	var   arrDateTime = sDateTime.split(" ");
	if(arrDateTime.length==1)
	{
		return isDate(arrDateTime[0]); //exit
	}
	if(arrDateTime.length==2)
	{
		return (isDate(arrDateTime[0]) && isTime(arrDateTime[1])); //exit
	}
	return false; //exit
}

//????radio??
function returnRadioValue(radioList){

  var i = 0;
  var value;
  if(radioList==null){
    return null;
  }
  else if (radioList.length==null){
    if (radioList.checked){
      value = radioList.value;
    }
  }
  else {
    for(i=0;i<radioList.length;i++){
      if (radioList[i].checked){
        value = radioList[i].value;
        break;
      }
    }
  }
  return value;
}

//??????????????????????beginDate>endDate ??????????
function checkLogicDate(beginDate,endDate)
{
	var bDate;
	var eDate;

	//????????????
	bDate = eval(beginDate.substring(0,beginDate.indexOf("-")));
	eDate = eval(endDate.substring(0,endDate.indexOf("-")));
	if (bDate>eDate)
	{
		return "????????????????????????????????????????????????";
	}
	else
	{
		if (bDate<eDate)
		{
			return "";
		}
	}

	//????????????
	bDate = eval(beginDate.substring(beginDate.indexOf("-")+1,beginDate.lastIndexOf("-")));
	eDate = eval(endDate.substring(endDate.indexOf("-")+1,endDate.lastIndexOf("-")));
	if (bDate>eDate)
	{
		return "????????????????????????????????????????????????";
	}
	else
	{
		if (bDate<eDate)
		{
			return "";
		}
	}

	//????????????
	bDate = eval(beginDate.substring(beginDate.lastIndexOf("-")+1,beginDate.length));
	eDate = eval(endDate.substring(endDate.lastIndexOf("-")+1,endDate.length));
	if (bDate>eDate)
	{
		return "????????????????????????????????????????????????";
	}
	return "";
}

function checkItem(str,maxLen,isMust){
  if(str == null || str == ""||Trim(str)==""){
      if (isMust == '0')
        return null;
      else
        return "\u4E0D\u80FD\u4E3A\u7A7A";
  }
  else{
    num =str.length;
    var arr=str.match(/[^\\\\\\\\\\\\\\\\x00-\\\\\\\\\\\\\\\\x80]/ig);
    if(arr!=null){
      for (var nIndex=0;nIndex<arr.length;nIndex++){
       if (arr[nIndex]!=" "){
         num++;
       }
      }
    }
    if(num >maxLen)
      return "\u4E0D\u80FD\u8D85\u8FC7"+ maxLen + "\u5B57\u7B26";
  }

  return null;
}

function bodyDBclick(){
	try{
		if(parent.frmset.cols=="190,*"){
			parent.frset.rows="0,*,0";
			parent.frmset.cols="0,*";
		} else {
			parent.frmset.cols="190,*";
			parent.frset.rows="133,*,31";
		}
	}catch (e){}
 }
function warning(){
    if(document.forms[0].alertStr.value!=""){
      alert(document.forms[0].alertStr.value);
    }
}

function changeFrame(flag){
  if(flag=="single"){
    parent.text.cols="0,*";
  }else{
    parent.text.cols="190,*"
  }
}
 function shown(){
    if(document.forms[0].alertStr.value!=""){
      alert(document.forms[0].alertStr.value);
    }
  }
  
  function checkEnterCode(value){
    var num=meizz(value);
    var recode="";
    for (var i=0;i<num.length;i++){
     var oneChar = num.charAt(i);
      if (oneChar>"a"&&oneChar<"z"){
		  oneChar=oneChar.toUpperCase();
	  }
      recode +=oneChar;
    }
    if (recode.length==9){
      recode=recode.substring(0,8)+'-'+recode.substring(8,9);
    }
    return recode;
    
  }
  
   function meizz(str)
  {   
     var tmp = "";     
     for(var i=0;i<str.length;i++){
        if(str.charCodeAt(i)>65248) {   
          tmp+=String.fromCharCode(str.charCodeAt(i)-65248);   
        }else{   
          tmp+=str.charAt(i);   
        }
     }   
    return tmp;   
  }
  
function move_Item(fromList, toList){
    for (var i = 0; i < fromList.options.length; i++) {
		  if(fromList.options[i].selected && fromList.options[i].value != "") {
				toList.add(new Option(fromList.options[i].text, fromList.options[i].value));
				fromList.options[i].removeNode(true);
				i--;
		  }
	}
}

function move_single(fromList, toList){
    var selIndex = fromList.selectedIndex;
    if (selIndex >= 0) {
		toList.add(new Option(fromList.options[selIndex].text, fromList.options[selIndex].value));
		fromList.options[selIndex].removeNode(true);
	}
}

function move_all(fromList, toList){
    for (var i = 0; i < fromList.options.length; i++) {
		toList.add(new Option(fromList.options[i].text, fromList.options[i].value));
	}
	fromList.options.length = 0; 
}

function reset(){
	document.forms(0).reset();
	return false;
}

function getFileSize (files)   {  
    var mySize = 0;
    if(files != null){   
	    var fso,f;  
	    fso = new ActiveXObject("Scripting.FileSystemObject");  
	    f = fso.GetFile(files);
	    mySize = f.size/1024/1024;
	}
    return mySize;
}

function editForceInfo(forceObjectID) {
	window.open("FoBasic.do?action=edit&forceObjectID=" + forceObjectID);
}

function viewForceInfo(forceObjectID) {
	window.open("FoResult.do?action=foResultView&forceObjectID=" + forceObjectID);
}

function doUploadFile(forceObjectID,process_no,pageType) {
	document.forms[0].action.value = "uploadFile";
	document.forms[0].forceObjectID.value = forceObjectID;
	document.forms[0].process_no.value = process_no;
	document.forms[0].type.value = pageType;
	document.forms[0].submit();
            
}

function doDeleteFile(forceObjectID,process_no,doc_no,pageType,docType) {
	document.forms[0].action.value = "deleteFile";
	document.forms[0].forceObjectID.value = forceObjectID;
	document.forms[0].process_no.value = process_no;
	document.forms[0].doc_no.value = doc_no;
	document.forms[0].type.value = pageType;
	document.forms[0].docType.value = docType;
	document.forms[0].submit();     
}

function doViewFile(forceObjectID,process_no,doc_no,pageType,docType) {
    window.open("FoResult.do?action=viewFile&forceObjectID=" + forceObjectID + "&process_no=" + process_no
        + "&doc_no=" + doc_no + "&type=" + pageType + "&docType=" + docType);
	/**document.forms[0].action.value = "viewFile";
	document.forms[0].forceObjectID.value = forceObjectID;
	document.forms[0].process_no.value = process_no;
	document.forms[0].doc_no.value = doc_no;
	document.forms[0].type.value = pageType;
	document.forms[0].docType.value = docType;
	document.forms[0].submit();   */   
}

function btn_save(forceObjectID,process_no,type) {
	if(checkNeedValue()) {
		document.forms[0].action.value = "save";
		document.forms[0].forceObjectID.value = forceObjectID;
		document.forms[0].process_no.value = process_no;
		document.forms[0].type.value = type;
		document.forms[0].submit();
	}
}

function backShow() {
	document.forms[0].action.value = "backShow";
	document.forms[0].submit();
}