package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(getBucketCount(1.0,2.1,1.5,7));
    }
    public static int getBucketCount(double width,double height,double areaPerbucket,int extraBuckets){
        if((width<=0)||(height<=0)||(areaPerbucket<=0)||(extraBuckets<0)){
            return -1;
        }
        else {
            double area=width*height;
            double noOfBuckets=area / areaPerbucket;

            noOfBuckets=noOfBuckets-extraBuckets+1;
            return (int)noOfBuckets;

        }

    }public static int getBucketCount(double width,double height,double areaPerbucket){
        if((width<=0)||(height<=0)||(areaPerbucket<=0)){
            return -1;
        }
        else {
            double area=width*height;
            double noOfBuckets=(area / areaPerbucket)+1;

            return (int)noOfBuckets;

        }

    }
    public static int getBucketCount(double area,double areaPerbucket){
        if((area<=0)||(areaPerbucket<=0)){
            return -1;
        }
        else {
            double noOfBuckets=(area / areaPerbucket)+1;
            return (int)noOfBuckets;

        }

    }

}
