package com.digdes.school;


public class Main {
    public static void main(String[] args) {
        Starter starter = new Starter();
        starter.execute("INSERT VALUES ‘lastName’ = ‘Федоров’ , ‘id’=3, ‘age’=40, ‘active’=true");
        starter.execute("INSERT VALUES ‘lastName’ = ‘Федоров’ , ‘id’=5, ‘age’=40, ‘active’=false");
        /*starter.execute("INSERT VALUES ‘lastName’ = ‘едоров’ , ‘id’=6, ‘age’=55, ‘active’=false");
        starter.execute("INSERT VALUES ‘lastName’ = ‘доров’ , ‘id’=3, ‘age’=45, ‘active’=true");
        starter.execute("UPDATE VALUES ‘active’=false, where ‘id’=3");
        starter.execute("DELETE VALUES ‘lastName’ = ‘доров’");*/
    }
}