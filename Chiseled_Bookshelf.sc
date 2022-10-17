__command() -> build();
build(xx,yy,zz) -> (
    run('carpet fillUpdates false');
    log = block('stripped_jungle_log');
    red = synchronize(read_file('Chiseled_Bookshelf_Data', 'shared_text'));
    game_tick();
    width = number(red:0)-1;
    height = number(red:1);
    print(width);
    print(height);
    h=0;
    volume(xx,yy,zz,xx+width,yy+height-1,zz,set(_,log));
    loop(width+1,c=_;
        loop(height,r=_;
        top = red:((r+(c*height))*2+2);
        bottom = red:((r+(c*height))*2+3);
        h+=1;
        if(h%1000==0,game_tick());
        run('setblock '+(number(xx)+c)+' '+(number(yy+height-1)-r)+' '+(number(zz)+1)+' minecraft:redstone_wire'+top);
        run('setblock '+(number(xx)+c)+' '+(number(yy+height-1)-r)+' '+(number(zz)+2)+' minecraft:redstone_wire'+bottom);
    ));
    run('carpet fillUpdates true');
);