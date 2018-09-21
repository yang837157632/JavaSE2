package Volume_I.Chapter5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * Created by Star Yang on 2017/1/14.
 * getXXX return public of this + super
 * getDeclaredXXX return public + default + protected + private of this
 * Exception extends Throwable extends Object
 */
public class D_Reflection {
    public static void main(String[] args){
        String name;
        if(args.length>0){
            name = args[0];
        }else{
            Scanner in = new Scanner(System.in);
            System.out.print("Please input the class name(eg. java.util.Date):  ");
            name = in.next();
        }

        try{
            Class c = Class.forName(name);
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length()>0){
                System.out.print(modifiers+" ");
            }
            System.out.print("class "+name);

            Class exClass = c.getSuperclass();
            if(exClass!=null && exClass != Object.class){
                System.out.print(" extends "+ exClass.getName());
            }

            Class[] imClass = c.getInterfaces();
            if(imClass.length>0){
                System.out.print(" implements ");
                for(int i=0;i<imClass.length;i++){
                    if(i>0){
                        System.out.print(",");
                    }
                    System.out.print(imClass[i].getName());
                }
            }

            System.out.println("{");
            printConstructors(c);
            System.out.println();
            printMethods(c);
            System.out.println();
            printFields(c);
            System.out.println("}");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void printConstructors(Class c){
        Constructor[] constructors = c.getConstructors();
        for(Constructor constructor : constructors){
            String name = constructor.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(constructor.getModifiers());
            if(modifiers.length()>0){
                System.out.print(modifiers+" ");
            }
            System.out.print(name+"(");

            Class[] paramTypes = constructor.getParameterTypes();
            for(int j=0;j<paramTypes.length;j++){
                if(j>0){
                    System.out.print(",");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class cl){
        Method[] methods = cl.getDeclaredMethods();
        for (Method method:methods){
            Class retType = method.getReturnType();
            String name = method.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(retType.getModifiers());
            if(modifiers.length()>0){
                System.out.print(modifiers+" ");
            }
            System.out.print(retType.getName()+" "+name+"(");

            Class[] paramTypes = method.getParameterTypes();
            for(int j=0;j<paramTypes.length;j++){
                if(j>0){
                    System.out.print(",");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class cl){
        Field[] fields = cl.getDeclaredFields();
        for(Field field: fields){
            Class Type = field.getType();
            String name = field.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(field.getModifiers());
            if(modifiers.length()>0){
                System.out.print(modifiers+" ");
            }
            System.out.println(Type.getName()+" "+name+";");
        }
    }
}
