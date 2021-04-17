#include <stdio.h>
#include <stdlib.h>

int isAJpg(unsigned char bytes[]);

int main(int argc, char *argv[])
{
    if (argc != 2)
    {
        return 1;
    }
    FILE *file = fopen(argv[1], "r");
    if (file == NULL)
    {
        return 1;
    }

    char filename[10];
    int count = 0;
    unsigned char bytes[512];
    FILE *output;
    int jpgfound = 0;

    while (fread(bytes, 512, 1, file) != 0)
    {
        // if it is a jpg
        if (isAJpg(bytes) == 1)
        {
            if (jpgfound == 1)
            {
                fclose(output);
            }
            else
            {
                jpgfound = 1;
            }
            // name file
            sprintf(filename, "%03d.jpg", count);

            // open file
            output = fopen(filename, "a");

            // increment count
            count++;
        }
        if (jpgfound == 1)
        {
            // writes to a file
            fwrite(&bytes, 512, 1, output);
        }
    }
    //close the files
    fclose(output);
    fclose(file);
}

// check if it is a jpg
int isAJpg(unsigned char bytes[])
{
    if (bytes[0] == 0xff && bytes[1] == 0xd8 && bytes[2] == 0xff && (bytes[3] & 0xf0) == 0xe0)
    {
        return 1;
    }
    return 0;
}