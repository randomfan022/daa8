#include<stdio.h> 
#include<stdlib.h> 
#include<math.h> 
#include<time.h> 
int a[1000],b[1000]; 
void merge(int low,int mid,int high) 
{ 
 int x,y,z,k; 
 x=low; 
 y=low; 
 z=mid+1; 
 while((x<=mid)&&(z<=high)) 
 { 
 if(a[x]<=a[z]) 
 { 
 b[y]=a[x]; 
 x++; 
 } 
 else 
 { 
 b[y]=a[z]; 
 z++; 
 } 
 y++; 
 } 
 if(x>mid) 
 { 
 for(k=z;k<=high;k++) 
 { 
 b[y]=a[k]; 
 y++; 
 } 
 } 
 else 
 { 
 for(k=x;k<=mid;k++) 
 { 
 b[y]=a[k];
 k++; 
 } 
 } 
 for(k=low;k<=high;k++) 
 { 
 a[k]=b[k]; 
 } 
} 
void merge_sort(int low,int high) 
{ 
 int mid; 
 if(low<high) 
 { 
 mid=(low+high)/2; 
 merge_sort(low,mid); 
 merge_sort(mid+1,high); 
 merge(low,mid,high); 
 } 
} 
int main(){ 
 int n,i; 
 clock_t start,end; 
 double clk; 
 printf("ENTER THE NO. OF CALLS\n"); 
 scanf("%d",&n); 
 
 for(i=0;i<n;i++) 
 a[i]=rand()%100; 
 
 printf("THE PHONE NO.s ARE:\n"); 
 for(i=0;i<n;i++) 
 printf("%d\t",a[i]); 
 printf("\n"); 
 
 start=clock(); 
 merge_sort(0,n-1);
 end=clock(); 
 clk=(double)(end-start)/CLOCKS_PER_SEC; 
 
 printf("THE SORTED PHONE NO.S ARE:\n"); 
 for(i=0;i<n;i++) 
 printf("%d\t",a[i]); 
 printf("\n"); 
 
 printf("TIME TAKEN FOR EXECUTION: %f\n",clk); 
}
