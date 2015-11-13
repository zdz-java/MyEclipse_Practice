


function isNumberString (InString,RefString){
	if(InString.length==0) return (false);
	for (Count=0; Count < InString.length; Count++){
		TempChar= InString.substring (Count, Count+1);
		if (RefString.indexOf (TempChar, 0)==-1)  
		return (false);
	}
	return (true);
}

function isIDString (idnum)
{
	var re=/^[\w][\w-.]*[\w]$/i;
	if(re.test(idnum))
		return true;
	else
		return false;
}

function ckid(idtype,idnum){
	if ( idtype(idtype) )
	   return ckidnum(idnum);
	else
		return false;
}

function ckidtype(idtype){
	
  if ( idtype.value < 0 || idtype.value > 3 ){
    alert("\����ѡ����ȷ��֤����� !!")
    return false;
  }
  return true;
}

function ckidnum(idtype,idnum){
	if ( idnum.length == 0 ){
		   alert("\��������֤������ !!")
		   return false;
	}
	
	var same = true
	for (Count=1; Count < idnum.length; Count++){
		if (  idnum.substring (Count, Count+1) != idnum.substring (Count-1, Count) )  {
		     same=false
		     break;
		}
	}
	if ( same ){
		 alert("\֤��������� !!")
		 return false;
	}
	
	if ( idtype == 0){
		if( idnum.length !=15 && idnum.length !=18 ) {
		   alert("\��������15/18λ����ȷ���֤�� !!")
		   return false;
	    }
		if( idnum.length ==15 && isNumberString(idnum,"1234567890")!=1){
		   alert("\����������֤�ź��зǷ��ַ� !!")
		   return false;
		}
		if ( idnum.length ==18 ){
			var cardNo= idnum.substring(0,17);
			if (isNumberString(cardNo,"1234567890")!=1){
				alert("\����������֤�ź��зǷ��ַ� !!")
				return false;
			}
			cardNo= idnum.substring(17,18);
			if (isNumberString(cardNo,"1234567890Xx")!=1){
				alert("\����������֤�ź��зǷ��ַ� !!")
				return false;
			}
		}
  }else{
		if( idnum.length <6 || idnum.length >18 ) {
			alert("\����������Ч֤�����룬֤���ų�����6��18�� !!")
			return false;
		}
		if (!isIDString(idnum)){
			alert("\��Ч��֤�������ֻ�������֡���ĸ���!!")
			return false;
		}
  }
  return true;
}