var REQUEST_AUTOCOMPLETE_AJAX_UTILS=null;var REQUEST_FIREEVENT_AJAX_UTILS=null;var ID_OBJ_AUTOCOMPLETE_AJAX_UTILS=null;var AJAXUTILS_SEND_DISABLED=false;function AjaxAction(){this.req=new Object();this.queryString=null;this.method='POST';this.idObjetoAutoComplete='';this.req=AjaxUtils.defineBrowserAJAX();this.submitForm=function(theForm,action,fCallBack){this.queryString=AjaxUtils.generateQueryStringByForm(theForm);if(this.queryString.length>0){this.queryString+="&";}
this.queryString+="nocache="+new Date();this.req.onreadystatechange=fCallBack;try{this.req.open("POST",action,true);this.req.setRequestHeader("Content-type","application/x-www-form-urlencoded");this.req.setRequestHeader("encoding","UTF-8");this.req.setRequestHeader("charset","UTF-8");this.req.setRequestHeader("Content-length",this.queryString.length);this.req.setRequestHeader("Connection","close");this.req.setRequestHeader('Cache-Control','no-store, no-cache, must-revalidate');this.req.setRequestHeader('Cache-Control','post-check=0, pre-check=0');this.req.setRequestHeader('Pragma','no-cache');}catch(e){alert(e);}
this.req.send(this.queryString);};this.submitSubForm=function(theForm,nameSubForm,action,fCallBack){};this.submitObject=function(obj,action,fCallBack){this.queryString='';for(var property in obj){this.queryString+=encodeURIComponent(property)+"="+encodeURIComponent(AjaxUtils.converteCaracteresEspeciais(obj[property]));if(this.queryString.length>0){this.queryString+="&";}}
this.queryString+="nocache="+new Date();this.req.onreadystatechange=fCallBack;try{this.req.open("POST",action,true);this.req.setRequestHeader("Content-type","application/x-www-form-urlencoded");this.req.setRequestHeader("encoding","UTF-8");this.req.setRequestHeader("charset","UTF-8");this.req.setRequestHeader("Content-length",this.queryString.length);this.req.setRequestHeader("Connection","close");this.req.setRequestHeader('Cache-Control','no-store, no-cache, must-revalidate');this.req.setRequestHeader('Cache-Control','post-check=0, pre-check=0');this.req.setRequestHeader('Pragma','no-cache');}catch(e){alert(e);}
this.req.send(this.queryString);};this.submitObjectMethodGET=function(obj,action,fCallBack){this.queryString='';for(var property in obj){this.queryString+=encodeURIComponent(property)+"="+encodeURIComponent(AjaxUtils.converteCaracteresEspeciais(obj[property]));if(this.queryString.length>0){this.queryString+="&";}}
if(this.queryString.length>0){this.queryString+="&";}
this.queryString+="nocache="+new Date();this.req.onreadystatechange=fCallBack;try{this.req.open("GET",action+'?'+this.queryString,true);this.req.setRequestHeader("encoding","UTF-8");this.req.setRequestHeader("charset","UTF-8");this.req.setRequestHeader('Cache-Control','no-store, no-cache, must-revalidate');this.req.setRequestHeader('Cache-Control','post-check=0, pre-check=0');this.req.setRequestHeader('Pragma','no-cache');}catch(e){alert(e);}
this.req.send(null);};this.fireEventToAjaxForm=function(theForm,actionParm,evt){var obj=new Object();obj.method='execute';obj.parmCount='3';obj.parm1=DEFINEALLPAGES_getFacadeName(actionParm);obj.parm2='';obj.parm3=evt;this.queryString=AjaxUtils.generateQueryStringByForm(theForm);for(var property in obj){if(this.queryString.length>0){this.queryString+="&";}
this.queryString+=encodeURIComponent(property)+"="+encodeURIComponent(AjaxUtils.converteCaracteresEspeciais(obj[property]));}
this.queryString+="&nocache="+new Date();REQUEST_FIREEVENT_AJAX_UTILS=this.req;this.req.onreadystatechange=this.callBackEvent;try{actionParm+='.event';this.req.open("POST",actionParm,true);this.req.setRequestHeader("Content-type","application/x-www-form-urlencoded");this.req.setRequestHeader("encoding","UTF-8");this.req.setRequestHeader("charset","UTF-8");this.req.setRequestHeader("Content-length",this.queryString.length);this.req.setRequestHeader("Connection","close");this.req.setRequestHeader('Cache-Control','no-store, no-cache, must-revalidate');this.req.setRequestHeader('Cache-Control','post-check=0, pre-check=0');this.req.setRequestHeader('Pragma','no-cache');}catch(e){alert(e);}
this.req.send(this.queryString);};this.fireEventToAjaxFormWithCallBack=function(theForm,actionParm,evt,fCallBack){var obj=new Object();obj.method='execute';obj.parmCount='3';obj.parm1=DEFINEALLPAGES_getFacadeName(actionParm);obj.parm2='';obj.parm3=evt;this.queryString=AjaxUtils.generateQueryStringByForm(theForm);for(var property in obj){if(this.queryString.length>0){this.queryString+="&";}
this.queryString+=encodeURIComponent(property)+"="+encodeURIComponent(AjaxUtils.converteCaracteresEspeciais(obj[property]));}
this.queryString+="&nocache="+new Date();this.req.onreadystatechange=fCallBack;try{actionParm+='.event';this.req.open("POST",actionParm,true);this.req.setRequestHeader("Content-type","application/x-www-form-urlencoded");this.req.setRequestHeader("encoding","UTF-8");this.req.setRequestHeader("charset","UTF-8");this.req.setRequestHeader("Content-length",this.queryString.length);this.req.setRequestHeader("Connection","close");this.req.setRequestHeader('Cache-Control','no-store, no-cache, must-revalidate');this.req.setRequestHeader('Cache-Control','post-check=0, pre-check=0');this.req.setRequestHeader('Pragma','no-cache');}catch(e){alert(e);}
this.req.send(this.queryString);};this.sendAutoComplete=function(strObjectProcess,strEnviar,strMensagem,classAutoComplete,funcaoTratarSelecaoDoAutoComplete){REQUEST_AUTOCOMPLETE_AJAX_UTILS=this.req;ID_OBJ_AUTOCOMPLETE_AJAX_UTILS=this.idObjetoAutoComplete;this.submitObjectMethodGET({parm1:strEnviar,parm2:strMensagem,parm3:classAutoComplete,parm4:funcaoTratarSelecaoDoAutoComplete},strObjectProcess+'.complete',this.callBackAutoComplete);};this.callBackAutoComplete=function(){if(REQUEST_AUTOCOMPLETE_AJAX_UTILS.readyState==4){if(REQUEST_AUTOCOMPLETE_AJAX_UTILS.status==200){document.getElementById(ID_OBJ_AUTOCOMPLETE_AJAX_UTILS).innerHTML=REQUEST_AUTOCOMPLETE_AJAX_UTILS.responseText;var divAux=document.getElementById('DIV_AUX_'+ID_OBJ_AUTOCOMPLETE_AJAX_UTILS);if(divAux!=null&&divAux!=undefined){divAux.style.height=document.getElementById(ID_OBJ_AUTOCOMPLETE_AJAX_UTILS).offsetHeight;divAux.style.width=document.getElementById(ID_OBJ_AUTOCOMPLETE_AJAX_UTILS).offsetWidth;divAux.style.top=document.getElementById(ID_OBJ_AUTOCOMPLETE_AJAX_UTILS).style.top;divAux.style.left=document.getElementById(ID_OBJ_AUTOCOMPLETE_AJAX_UTILS).style.left;var fraAux=document.getElementById('FRA_AUX_'+ID_OBJ_AUTOCOMPLETE_AJAX_UTILS);fraAux.style.height=document.getElementById(ID_OBJ_AUTOCOMPLETE_AJAX_UTILS).offsetHeight;fraAux.style.width=document.getElementById(ID_OBJ_AUTOCOMPLETE_AJAX_UTILS).offsetWidth;divAux.style.display='block';}}}};this.callBackEvent=function(){if(REQUEST_FIREEVENT_AJAX_UTILS.readyState==4){if(REQUEST_FIREEVENT_AJAX_UTILS.status==200){var resposta=REQUEST_FIREEVENT_AJAX_UTILS.responseText;var objs=ObjectUtils.deserializeCollectionFromStringSemQuebraEnter(resposta);if(objs!=null){for(var j=0;j<objs.length;j++){eval(ObjectUtils.decodificaAspasApostrofe(objs[j].script));}}}}};}
function AjaxUtils(){}
AjaxUtils.converteCaracteresEspeciais=function(str){var encoded='';var strFinal='';for(var i=0;i<str.length;i++){encoded='';c=str.charAt(i);if (c == '�')
	encoded = "[[[cedilhamin]]]";
else if (c == '�')
	encoded = "[[[cedilhamai]]]";
else if (c == '�')
	encoded = "[[[aagudomin]]]";
else if (c == '�')
	encoded = "[[[aagudomai]]]";
else if (c == '�')
	encoded = "[[[acrasemin]]]";
else if (c == '�')
	encoded = "[[[acrasemai]]]";		
else if (c == '�')
	encoded = "[[[eagudomin]]]";
else if (c == '�')
	encoded = "[[[eagudomai]]]";
else if (c == '�')
	encoded = "[[[iagudomin]]]";
else if (c == '�')
	encoded = "[[[iagudomai]]]";
else if (c == '�')
	encoded = "[[[oagudomin]]]";
else if (c == '�')
	encoded = "[[[oagudomai]]]";
else if (c == '�')
	encoded = "[[[uagudomin]]]";
else if (c == '�')
	encoded = "[[[uagudomai]]]";
else if (c == '�')
	encoded = "[[[acircmin]]]";
else if (c == '�')
	encoded = "[[[acircmai]]]";
else if (c == '�')
	encoded = "[[[ecircmin]]]";
else if (c == '�')
	encoded = "[[[ecircmai]]]";
else if (c == '�')
	encoded = "[[[icircmin]]]";
else if (c == '�')
	encoded = "[[[icircmai]]]";
else if (c == '�')
	encoded = "[[[ocircmin]]]";
else if (c == '�')
	encoded = "[[[ocircmai]]]";
else if (c == '�')
	encoded = "[[[ucircmin]]]";
else if (c == '�')
	encoded = "[[[ucircmai]]]";
else if (c == '�')
	encoded = "[[[atilmin]]]";
else if (c == '�')
	encoded = "[[[atilmai]]]";
else if (c == '�')
	encoded = "[[[otilmin]]]";
else if (c == '�') 
	encoded = "[[[otilmai]]]";
else if (c == '&') 
	encoded = "[[[ehcomercial]]]";
else 
	encoded = c;
strFinal+=encoded;}
return strFinal;}
AjaxUtils.defineBrowserAJAX=function(){var http_request=false;if(window.XMLHttpRequest){http_request=new XMLHttpRequest();if(http_request.overrideMimeType){http_request.overrideMimeType('text/html');}}else if(window.ActiveXObject){try{http_request=new ActiveXObject("Msxml2.XMLHTTP");}catch(e){try{http_request=new ActiveXObject("Microsoft.XMLHTTP");}catch(e){}}}
if(!http_request){alert('Cannot create XMLHTTP instance #####');return false;}
return http_request;};AjaxUtils.generateQueryStringByForm=function(theform){var els=theform.elements;var len=els.length;var queryString="";this.addField=function(name,value){if(queryString.length>0){queryString+="&";}
queryString+=encodeURIComponent(name)+"="+encodeURIComponent(AjaxUtils.converteCaracteresEspeciais(value));};for(var i=0;i<len;i++){var el=els[i];var bProcessar=true;if(AJAXUTILS_SEND_DISABLED){bProcessar=true;}else{if(el.disabled){bProcessar=false;}}
if(bProcessar){switch(el.type){case'text':case'password':case'hidden':case'textarea':this.addField(el.name,el.value);break;case'select-one':if(el.selectedIndex>=0){this.addField(el.name,el.options[el.selectedIndex].value);}
break;case'select-multiple':for(var j=0;j<el.options.length;j++){if(el.options[j].selected){this.addField(el.name,el.options[j].value);}}
break;case'checkbox':case'radio':if(el.checked){this.addField(el.name,el.value);}
break;}}}
return queryString;};var AjaxUtils_objAutoComplete=null;AjaxUtils.autoComplete=function(obj,evtKeyDown,idDivRetorno,nomeClasseAutoComplete,mensagem,classAutoComplete,funcaoTratarSelecaoDoAutoComplete){var funcaoTrtAutoCompl=funcaoTratarSelecaoDoAutoComplete;if(arguments.length<7){funcaoTrtAutoCompl='selecionaAutoComplete';}
AjaxUtils_objAutoComplete=obj;var curleft=0;var curtop=0;var objAux=obj;if(objAux.offsetParent){do{curleft+=objAux.offsetLeft;curtop+=objAux.offsetTop;}while(objAux=objAux.offsetParent);}
document.getElementById(idDivRetorno).style.left=curleft+'px';document.getElementById(idDivRetorno).style.top=(curtop+obj.offsetHeight)+'px';var nTecla;var valor=obj.value;if(document.all){nTecla=evtKeyDown.keyCode;}else{nTecla=evtKeyDown.which;}
if(nTecla==8){if(valor.length>0){if(valor.length==1){valor='';}else{valor=valor.substr(0,valor.length-1);}}}else{if(nTecla!=undefined){if(nTecla==13||nTecla==16||nTecla==17||nTecla==20||nTecla==33||nTecla==34||nTecla==37||nTecla==38||nTecla==39||nTecla==40){}else{valor=valor+String.fromCharCode(nTecla);}}}
if(valor==''||valor==' '||valor==null||valor==undefined||nTecla==9){document.getElementById(idDivRetorno).innerHTML='';document.getElementById(idDivRetorno).style.display='none';document.getElementById('DIV_AUX_'+idDivRetorno).style.display='none';return;}
var ajaxAction=new AjaxAction();ajaxAction.idObjetoAutoComplete=idDivRetorno;ajaxAction.sendAutoComplete(nomeClasseAutoComplete,valor,mensagem,classAutoComplete,funcaoTrtAutoCompl);document.getElementById(idDivRetorno).style.display='block';};AjaxUtils.fecharAutoComplete=function(idDivRetorno){document.getElementById(idDivRetorno).style.display='none';var divAux=document.getElementById('DIV_AUX_'+idDivRetorno);divAux.style.display='none';};