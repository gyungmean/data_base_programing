package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	// requestï¿½ï¿½ Ã³ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ ï¿½Ìµï¿½ï¿½ï¿½ URLï¿½ï¿½ ï¿½ï¿½È¯
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    		throws Exception;
}
//Ã¤¿¬ÀÇ¤·¤·¤·