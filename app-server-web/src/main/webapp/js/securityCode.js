var code ; 
function createCode()
{     
  code = "";   
  var codeLength = 4; 
  var checkCode = document.getElementById("checkCode");   
  var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');//????????????,?????????   
      
  for(var i=0;i<codeLength;i++)   
  {     
      
  var charIndex = Math.floor(Math.random()*36);   
  code +=selectChar[charIndex];           
     
  }   
  if(checkCode)   
  {   
    
    checkCode.value = code; 
  }   
     
}   

function validateCode()
{   
  var inputCode = document.getElementById("codeContent").value; 
  document.getElementById("codetip").innerHTML ="";   
  if(inputCode.length <=0)   
  {   
      document.getElementById("codetip").innerHTML ="请输入验证码"; 
      createCode(); 
	  return false;
  }   
  else if(inputCode.toLowerCase() != code.toLowerCase() )   
  {    
     document.getElementById("codetip").innerHTML="验证码输入错误"; 
     createCode(); 
     return false; 
  }   
  else   
  {   
     return true; 

  }   
     
  } 