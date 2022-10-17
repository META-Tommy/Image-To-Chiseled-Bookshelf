# Image-To-Chiseled-Bookshelf
Convert an image to a chiseled bookshelf in Minecraft: Java Edition!

![Larcei](https://guide.fire-emblem-heroes.com/wp-content/uploads/larcei_keen_kin.png)![Larcei in Bookshelf Forme](https://i.imgur.com/YaGLB1G.png)
# What third part items do I need to use this?
Java, Minecraft: Java Edition, [Fabric](https://fabricmc.net/), and [Carpet mod](https://www.curseforge.com/minecraft/mc-mods/carpet)

If the resource pack doesn't work, you might also need [optifine](https://optifine.net/downloads)/[optifabric](https://www.curseforge.com/minecraft/mc-mods/optifabric) or some equivalent
# How does this work?
Using a resource pack, we can change the model and texture of redstone wire to be a row of books. I used redstone wire because it is a transparent block with the most block states. We place the redstone wire in such a way using [scarpet](https://github.com/gnembon/scarpet), which is included in [carpet mod](https://www.curseforge.com/minecraft/mc-mods/carpet). Since each bookshelf has 2 rows and the redstone wire represents 1 row, each bookshelf has 2 redstone wire infront of it. The bookshelves can only point south. Theoretically it'd be possible to rotate them in all 4 directions since block states can rotate block models, but I didn't. Stripped Jungle Logs are used as the Empty Chiseled Bookshelf for no particular reason.
![:Image of Floating Redstone Wire:](https://imgur.com/r07915E.png)
# Prepare an Image for Conversion
This step isn't strictly required but it helps with making sure the output is what you want!

Resize the image such that the width is 1.5x larger. This is because bookshelves are 3x2 books, so for the pixels to line up with the thin books, the image needs to initially be stretched horizontally

Then, decide the size of the bookshelf you want. In the example above I chose a bookshelf that's 60 blocks tall.

Resize the entire image, maintaining the aspect ratio, such that the height equals 2 times the size of the bookshelf you want. For my example I'd make my image 120 pixels tall

If the image has any transparency, add a background. My program doesn't work with transparency

You can use an image filter, such as [paint.net's recolor using palette filter](https://forums.getpaint.net/topic/111468-recolor-using-palette/) to reduce the color of the input image to determine exactly how your image will look, but this is optional

If you reduced the colors down to 7, you likely have to save the file as a `.jpg`, since the Java class I'm using does some funny stuff to `.png` images when they have a low amount of colors. **Ensure that you maintain maximum quality when converting to a `.jpg`!**

The default hex values for the bookshelf colors are 

    Blank:		#2E2011
    Magenta:	#883047
    Orange:		#774835
    Green:		#476625
    Cyan:		#12605E
    Blue:		#1B3B6E
    Purple:		#51216E
Example Image:

![Larcei](https://guide.fire-emblem-heroes.com/wp-content/uploads/larcei_keen_kin.png)

Example Image after doing the above steps:

![Larcei Example](https://i.imgur.com/GO4xwBR.png)
# Convert an Image to Redstone Wire Blockstates
Download the `.jar` file

Open a command prompt where you downloaded the `.jar` file; you can do this in file explorer by typing `cmd` at the file location (the text box at the top of the file explorer where it says the folder address)

Do the command `ImageToChiseledBookshelf.jar "The location of the Image" "The location where you want the output Chiseled_Bookshelf_Data.txt file"`

For example `C:\Tommy\Downloads>ImageToChiseledBookshelf.jar "C:\Tommy\Downloads\Larcei.png" "C:\Tommy\Downloads"` would take the image Larcei.png and output `Chiseled_Bookshelf_Data.txt` inside the downloads folder

Don't put a backslash at the end of the output location
# What do I do with Chiseled_Bookshelf_Data.txt
Navigate to `.minecraft\saves` and find the world where you want to put the bookshelf in

Make sure cheats are enabled! (we are cheating)

Create a file inside the world called `scripts` and one inside that called `shared`. The file directory should look like `.minecraft\saves\YOUR_WORLD\scripts\shared`

Put `Chiseled_Bookshelf_Data.txt` inside `.minecraft\saves\YOUR_WORLD\scripts\shared` so [scarpet](https://github.com/gnembon/scarpet) can read it!
# Don't forget the resource pack!
Download the resource pack and load it into your game!

If the resource pack doesn't look correct in game, you might need to install [optifine](https://optifine.net/downloads)/[optifabric](https://www.curseforge.com/minecraft/mc-mods/optifabric) or some equivalent
# How do I use scarpet
Download and place `Chiseled_Bookshelf.sc` in `.minecraft\saves\YOUR_WORLD\scripts`

Open the your minecraft world and run the command `/script load chiseled_bookshelf`

Now you can run `/chiseled_bookshelf build x y z`, where x, y, and z are the bottom left corner of the bookshelf you want to build

If the `/script` command doesn't exist, you don't have [Carpet mod](https://www.curseforge.com/minecraft/mc-mods/carpet)

If the `chiseled_bookshelf` script doesn't exist, you didn't put `Chiseled_Bookshelf.sc`  in the right location

This command will destroy any blocks that are in the way, so make sure you have a world backup incase a giant bookshelf bursts through your roof!
# Useful tips
You can use the carpet command `/carpet interactionUpdates false` to make it so that you can place blocks adjacent to floating redstone wire without it updating! `/carpet fillUpdates false` is the same thing but for the `/fill` and `/setblock` command

You can set the output of the .jar file to do be `.minecraft\saves\YOUR_WORLD\scripts\shared` and it'll automatically put `Chiseled_Bookshelf_Data.txt` in a place where scarpet can read it

Place a repeating command block nearby with the command `/kill @e[type=item]` to prevent a block update from creating thousands of redstone dust items! This will cause all items to despawn while the command block is loaded so be careful (not recommend for survival for obvious reasons lol)
