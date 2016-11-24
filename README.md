![t1-plugin build status](https://travis-ci.org/Magikcraft/t1-plugin.svg?branch=master)

# t1-plugin

Source code for the functionality of the mct1 initiative. This repository
is intended to be used with the Magikcraft/t1-server repository but is not
specifically coupled with it in any way. So you may configure your own minecraft ([spigot](https://www.spigotmc.org/wiki/spigot-installation/)/[paper](https://paper.readthedocs.io/en/paper-1.10/)/[bukkit](https://bukkit.org/))
sever to run the plugin.

## The MCT1 Initiative
Here you can find a blurb detailing what is trying to be achieved with this plugin

### Docker
This repository contains a docker file that allows you to build a runnable image that
contains a fully configured server which will run the **t1-plugin** and other common utility plugins.

#### Users
if you just want get mct1 up and running all you need is a functional docker installation
and then do:
```
docker run -p 25565:25565 magikcraft/t1-pie
```
If you don't want to host the server on port `25565` then you will
need to change it appropriately eg:
```
docker run -p [your-host-port]:25565 magikcraft/t1-pie
```

#### Developers
If you are developing the plugin you will want to build on localhost to improve development
time to do this there are two steps:

  1. compile and package the plugin using `mvn clean package` in repository root dir 
  2. build the pie image with `docker build -t t1-pie .` in repository root dir
  3. (Ok its technically 3 steps) launch server with `docker run -p [host-port]:25565 t1-pie`
  
#### Updating magikcraft/t1-pie
The packaged magikcraft/t1-pie image is built from the master branch, if you wish to make a change to that
image you must create a pull request to master.

In the future other branches may have their own variant of the magikcraft/t1-pie image.
