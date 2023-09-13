/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StandardPackage;

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
    private HashMap<String,Integer> counterMap=new HashMap<>();
    
    @AroundInvoke
    public Object logMethod(InvocationContext cnt) throws Exception{
        String key=cnt.getMethod().getName();
        int value=0;
        if(!counterMap.containsKey(key))
            counterMap.put(key, value);
        value=counterMap.get(key) + 1;
        counterMap.put(key,value);
        System.out.println("Chiamata n "+value+" : "+key);
        return cnt.proceed();
    } 
}
