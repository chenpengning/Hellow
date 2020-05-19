// IDate.aidl
package com.example.hellow.aidl;

// Declare any non-default types here with import statements

//import com.example.hellow.aidl.Student;
parcelable Student;


interface IDate {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    void addStudent(in Student student);

    List<Student> getListstu();







}
