#include "helpers.h"
#include <math.h>
#include <stdio.h>
#include <string.h>

// Convert image to grayscale
void grayscale(int height, int width, RGBTRIPLE image[height][width])
{
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            int average = round(((double) image[i][j].rgbtRed + (double) image[i][j].rgbtGreen + (double) image[i][j].rgbtBlue) / 3);
            
            image[i][j].rgbtRed = average;
            image[i][j].rgbtBlue = average;
            image[i][j].rgbtGreen = average;
        }
    }
}

// Convert image to sepia
void sepia(int height, int width, RGBTRIPLE image[height][width])
{
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            int red = image[i][j].rgbtRed;
            int green = image[i][j].rgbtGreen;
            int blue = image[i][j].rgbtBlue;

            red = round(red);
            green = round(green);
            blue = round(blue);

            double sepiaRed1 = (0.393 * red) + (0.769 * green) + (0.189 * blue);
            double sepiaGreen1 = (0.349 * red) + (0.686 * green) + (0.168 * blue);
            double sepiaBlue1 = (0.272 * red) + (0.534 * green) + (0.131 * blue);

            int sepiaRed = round(sepiaRed1);
            int sepiaGreen = round(sepiaGreen1);
            int sepiaBlue = round(sepiaBlue1);

            if (sepiaRed > 255)
            {
                sepiaRed = 255;
            }
            if (sepiaBlue > 255)
            {
                sepiaBlue = 255;
            }
            if (sepiaGreen > 255)
            {
                sepiaGreen = 255;
            }

            image[i][j].rgbtRed = sepiaRed;
            image[i][j].rgbtGreen = sepiaGreen;
            image[i][j].rgbtBlue = sepiaBlue;

        }
    }
}

// Reflect image horizontally
void reflect(int height, int width, RGBTRIPLE image[height][width])
{
    int widthPt2 = width;
    if (widthPt2 % 2 == 1)
    {
        widthPt2--;
        widthPt2 /= 2;
    }
    else
    {
        widthPt2 /= 2;
    }
    for (int i = 0; i < height; i++)
    {
        int x = width - 1;
        for (int j = 0; j < widthPt2; j++)
        {
            int tempRed1 = image[i][j].rgbtRed;
            int tempGreen1 = image[i][j].rgbtGreen;
            int tempBlue1 = image[i][j].rgbtBlue;

            image[i][j].rgbtRed = image[i][x].rgbtRed;
            image[i][j].rgbtGreen = image[i][x].rgbtGreen;
            image[i][j].rgbtBlue = image[i][x].rgbtBlue;

            image[i][x].rgbtRed = tempRed1;
            image[i][x].rgbtGreen = tempGreen1;
            image[i][x].rgbtBlue = tempBlue1;

            x--;
        }
    }
}

// Blur image
void blur(int height, int width, RGBTRIPLE image[height][width])
{
    RGBTRIPLE newImage[height][width];
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            newImage[i][j] = image[i][j];
        }
    }
    for (int i = 0, red, green, blue, counter; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            red = green = blue = counter = 0;
            // add the center pixel
            if (i >= 0 && j >= 0)
            {
                red += newImage[i][j].rgbtRed;
                green += newImage[i][j].rgbtGreen;
                blue += newImage[i][j].rgbtBlue;
                counter++;
            }
            // add below pixel
            if (i >= 0 && j - 1 >= 0)
            {
                red += newImage[i][j - 1].rgbtRed;
                green += newImage[i][j - 1].rgbtGreen;
                blue += newImage[i][j - 1].rgbtBlue;
                counter++;
            }
            // add right pixel
            if ((i >= 0 && j + 1 >= 0) && (i >= 0 && j + 1 < width))
            {
                red += newImage[i][j + 1].rgbtRed;
                green += newImage[i][j + 1].rgbtGreen;
                blue += newImage[i][j + 1].rgbtBlue;
                counter++;
            }
            // add left pixel
            if (i - 1 >= 0 && j >= 0)
            {
                red += newImage[i - 1][j].rgbtRed;
                green += newImage[i - 1][j].rgbtGreen;
                blue += newImage[i - 1][j].rgbtBlue;
                counter++;
            }
            // add left below pixel
            if (i - 1 >= 0 && j - 1 >= 0)
            {
                red += newImage[i - 1][j - 1].rgbtRed;
                green += newImage[i - 1][j - 1].rgbtGreen;
                blue += newImage[i - 1][j - 1].rgbtBlue;
                counter++;
            }
            // add left upper pixel
            if ((i - 1 >= 0 && j + 1 >= 0) && (i - 1 >= 0 && j + 1 < width))
            {
                red += newImage[i - 1][j + 1].rgbtRed;
                green += newImage[i - 1][j + 1].rgbtGreen;
                blue += newImage[i - 1][j + 1].rgbtBlue;
                counter++;
            }
            // add upper pixel
            if ((i + 1 >= 0 && j >= 0) && (i + 1 < height && j >= 0))
            {
                red += newImage[i + 1][j].rgbtRed;
                green += newImage[i + 1][j].rgbtGreen;
                blue += newImage[i + 1][j].rgbtBlue;
                counter++;
            }
            // add below right pixel
            if ((i + 1 >= 0 && j - 1 >= 0) && (i + 1 < height && j - 1 >= 0))
            {
                red += newImage[i + 1][j - 1].rgbtRed;
                green += newImage[i + 1][j - 1].rgbtGreen;
                blue += newImage[i + 1][j - 1].rgbtBlue;
                counter++;
            }
            // add upper right pixel
            if ((i + 1 >= 0 && j + 1 >= 0) && (i + 1 < height && j + 1 < width))
            {
                red += newImage[i + 1][j + 1].rgbtRed;
                green += newImage[i + 1][j + 1].rgbtGreen;
                blue += newImage[i + 1][j + 1].rgbtBlue;
                counter++;
            }

            image[i][j].rgbtRed = round(red / (counter * 1.0));
            image[i][j].rgbtGreen = round(green / (counter * 1.0));
            image[i][j].rgbtBlue = round(blue / (counter * 1.0));
        }
    }
}
