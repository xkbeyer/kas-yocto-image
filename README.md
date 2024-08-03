# Project
Serve as a playground for building a Linux image with support of Yocto.

# Requirements
- kas  
To simplify the build process `kas` is used. That makes it easier to support different local.conf setups,
More important, the Yocto build environment is independent from the host linux distribution. 
`kas` git repo: https://github.com/siemens/kas

# Build
Assuming the kas installation is in the `PATH`. In order to be independent from the host build tools (especially glibc version) I use the kas docker build.
```bash
kas-docker build myproduct.yaml
```
_Remark: You don't have to install kas, you can clone the repo and run it directly from there._

# QEMU

## Running with a build for qemux86_64
``` bash
kas-docker shell mydistro.yaml -c 'runqemu tmp/deploy/images/qemux86-64/xkb-core-qemux86-64.rootfs.qemuboot.conf nographic'
```
## Running with a build for myboard (QEMU and EFI bootloader)

Build once the `ovmf` in the kas-docker shell. 
``` bash
kas-docker shell mydistro.yaml -c 'bitbake ovmf'
```

``` bash
kas-docker --docker-args "--device /dev/net/tun:/dev/net/tun --cap-add=NET_ADMIN" shell mydistro.yaml
runqemu-gen-tapdevs
runqemu tmp/deploy/images/myboard/xkb-core-myboard.rootfs.wic nographic /path/to/ovmf.qcow2
```
_Remark: The `runqemu-gen-tapdevs` works mostly after a second run even if the script shows an error message._

# Current state
- qemu based image
- one user
- xkb distro
- myboard bsp with EFI bootloader
- hello world example application
