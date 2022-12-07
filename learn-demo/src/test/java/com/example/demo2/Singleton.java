package com.example.demo2;

/**
 * @author Wonder7zq
 * @date 2020/10/23 - 9:42
 */
public class Singleton
{
        private Singleton(){

        }
        private static  Singleton instance = new Singleton();
        public static Singleton getInstance(){
            return instance;
        }
}
