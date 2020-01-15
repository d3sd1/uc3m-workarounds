package helperfunc;

public class Arrays {
    public void orderArray(Object arrayRet)
    {
        Object getDataType = arrayRet.getClass().getComponentType();
        switch(getDataType.toString())
        {
            case "int":
                //this.orderArrayInt(arrayRet);
            break;
            case "class java.lang.String":
                //System.out.println(arrayRet.toString());
            break;
        }
    }
    private int[] orderArrayInt(int[] arrayRet)
    {
        int[] orderedArray = { };
        return orderedArray;
    }
    private String[] orderArrayString(String[] arrayRet)
    {
        System.out.println(arrayRet);
        String[] orderedArray = { };
        return orderedArray;
    }
}