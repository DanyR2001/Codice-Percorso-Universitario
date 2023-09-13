/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StandardPackage;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author danielerusso
 */
@Counter
@Interceptor
public class InterceptorCounter {
    
    private int count=0;
    
    @AroundInvoke
    public Object interc(InvocationContext ic ) throws Exception{
        count++;
        System.out.println("Stampa by bilancio invocato "+count+" volte");
        return ic.proceed();
    }
    
}
