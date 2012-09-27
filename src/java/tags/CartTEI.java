package tags;

import javax.servlet.jsp.tagext.*;

public class CartTEI extends TagExtraInfo
{
    public VariableInfo[] getVariableInfo(TagData data)
    {
        return new VariableInfo[]
        {
            new VariableInfo("productCode", "String", true, VariableInfo.NESTED), 
            new VariableInfo("productDescription", "String", true, VariableInfo.NESTED), 
            new VariableInfo("productPrice", "String", true, VariableInfo.NESTED), 
            new VariableInfo("quantity", "Integer", true, VariableInfo.NESTED), 
            new VariableInfo("total", "String", true, VariableInfo.NESTED), 
        };
    }
}