# About

FrinkBot allows you to run [Frink](http://futureboy.us/frinkdocs/) programs over IRC.

# Usage

Assuming [PircBot'](https://github.com/davidlazar/PircBot) is installed, build FrinkBot:

    $ ant

After editing `config.ini`, run FrinkBot:

    $ bin/frinkbot.sh config.ini

Talk to FrinkBot:

    <david> ~ Fahrenheit[451] -> Celsius
    <FrinkBot> 232.77777777777777778

    <david> ~ 720 Yen -> "USD"
    <FrinkBot> 9.202608 USD

    <david> ~ map[{|x| messageDigest[x, "MD5"]}, ["hello", "world"]]
    <FrinkBot> [5d41402abc4b2a76b9719d911017c592, 7d793037a0760186574b0282f2f435e7]

# Contributing

This project is available on [GitHub](https://github.com/davidlazar/FrinkBot) and [Bitbucket](https://bitbucket.org/davidlazar/frinkbot/). You may contribute changes using either.

Please report bugs and feature requests using the [GitHub issue tracker](https://github.com/davidlazar/FrinkBot/issues).
