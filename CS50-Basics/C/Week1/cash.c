#include<stdio.h>
#include<cs50.h>
#include<math.h>

int main(void)
{
    
    int dollars;
    int count = 0;
      
    while (true)
    {
        float money = get_float("change owed: ");   
        dollars = round(money * 100);
        if (dollars > 0)
        {
            break;
        }
    }
      
    for (int i = 0; dollars / 25 != 0; i++)
    {
        dollars -= 25;
        count++;
    }
    for (int i = 0; dollars / 10 != 0; i++)
    {
        dollars -= 10;
        count++;
    }
    for (int i = 0; dollars / 5 != 0; i++)
    {
        dollars -= 5;
        count++;
    }
    for (int i = 0; dollars / 1 != 0; i++)
    {
        dollars -= 1;
        count++;
    }
    printf("%i\n", count);
}