/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package standardPackage;

import java.util.HashMap;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author danielerusso
 */
@Interceptor
@Counter
public class CounterInterceptor {
    private HashMap<String,Integer> counter = new HashMap<String,Integer>();
    
    @AroundInvoke
    public Object count(InvocationContext ic) throws Exception{
        String NameMethod=ic.getMethod().getName();
        Integer value;
        if (NameMethod.equals("selectByVote")){
            value=(Integer) ic.getParameters()[0];
            if (value>10)
                return ic.proceed();  
            else
                return null;
        }
        else{
            if (!counter.containsKey(NameMethod))
                counter.put(NameMethod, 0);
            value=counter.get(NameMethod)+1;
            counter.put(NameMethod, value);
            System.out.println("Chiamata n. " + value +": metodo " + NameMethod);
            return ic.proceed();  
        }
    } 
}
