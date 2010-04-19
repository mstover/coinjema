var dateField = 0 ;

var currentMenu = "";
var previousMenu = "";

NS4 = (document.layers) ? 1 : 0;
IE4 = (document.all && !document.getElementById) ? 1 : 0;
IE5 = (document.all && document.getElementById) ? 1 : 0;
NS6 = (!document.all && document.getElementById) ? 1 : 0

function popUp(on)
{
   var ILay ;

   if (NS4) {
      ILay = document.layers['popCal'].document.layers['popCal'];
   }
   else if (IE4) {
      ILay = document.all['popCal'];
   }
   else if (IE5 || NS6) {
      ILay = document.getElementById('popCal');
   }

   if (on) {
      ILay.style.visibility = "visible";
   }
   else {
      ILay.style.visibility = "hidden";
   }
}

function setCookie(name,value)
{
	document.cookie="stratlib_"+name+"="+escape(value);
}

function getCurrentMenu()
{
	return currentMenu;
}

function enterMenu(menu)
{
	if(previousMenu != "" && previousMenu != menu)
	{
		setLayerVisible(false,previousMenu);
	}
	setLayerVisible(true,menu);
	currentMenu = menu;
	previousMenu = menu;
}

function exitMenu(menu)
{
	previousMenu = menu;
	currentMenu = "";
	var nowMenu = setTimeout("closeMenu()",1000);
}

function closeMenu()
{
	if(currentMenu == "")
	{
		setLayerVisible(false,previousMenu);
	}
}

function setLayerVisible(on,name)
{
	var ILay ;

   if (NS4) {
      ILay = document.layers[name].document.layers[name];
   }
   else if (IE4) {
      ILay = document.all[name];
   }
   else if (IE5 || NS6) {
      ILay = document.getElementById(name);
   }
   if(ILay != null)
   {
	   if (on) {
	      ILay.style.visibility = "visible";
	   }
	   else {
	      ILay.style.visibility = "hidden";
	   }
	}
}

function notValidDate(dateStr) {
   var datePat = /^\d{1,2}(\/)\d{1,2}(\/)\d{2,4}$/
   if (dateStr.match(datePat)) {
       return false
   } else {
       return true
   }
}

function SeeDate(dateValue)
{
  dateField.value = dateValue;

  HideDate();

  return;
}


function ShowDate(i)
{
  if (dateField != null) {
          HideDate() ;
  }

  dateField = i ;

  popUp(true);

  return;
}


function moveLayers()
{
   var ILay, x, y  ;

   x = 420 ;
   y = 460 + ((ilayer%100) * 16) ;

   if (NS4) {
      ILay = document.layers['FormLayer'].document.layers['popCal'];
   }
   else if (IE4) {
      ILay = document.all['popCal'];
   }
   else if (IE5 || NS6) {
      ILay = document.getElementById('popCal');
   }

   if (NS4) {
      ILay.left = x;
      ILay.top = y;
   } else {
      ILay.style.pixelLeft = x;
      ILay.style.pixelTop = y;
   }
}

function HideDate()
{
  popUp(false) ;

  return;
}

function redirect(url) {
  location.href=url;
}

function changeAction(f,act)
{
	f.action = act;
	f.submit();
}

function getRejectReason()
{
	return prompt("Please provide a reason for rejecting this request","");
}

function confirmAndCommit(message)
{
	if(confirm(message))
	{
		return true;
	}
	else
	{
		return false;
	}
}

function changeFormValue(element,val)
{
	element.value=val;
	element.form.submit;
}

function inArray(ary,item)
{
	for(var i = 0;i < ary.length;i++)
	{
		if(ary[i] == item) return true;
	}
	return false;
}

function showAnswer(el_id,q_id)
{
	el = document.getElementById(el_id);
	answer = document.getElementById("answer_window");
	answer.innerHTML=el.innerHTML;
	answer_label = document.getElementById("answer_label_window");
	answer_label.innerHTML = document.getElementById(q_id).innerHTML;
}
