SUMMARY = "Add users to the image"
DESCRIPTION = "This recipe adds the default user of the distribution"
SECTION = "User"
LICENSE = "CLOSED"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "file://.bashrc file://.profile file://10-john"
S = "${WORKDIR}"
USER_NAME="john"
GRP_NAME="develop"
EXCLUDE_FROM_WORLD = "1"
DEPENDS += " openssl-native sudo bash"

inherit useradd

# You must set USERADD_PACKAGES when you inherit useradd. This
# lists which output packages will include the user/group
# creation code.
USERADD_PACKAGES = "${PN}"

# USERADD_PARAM specifies command line options to pass to the
# useradd command. Multiple users can be created by separating
# the commands with a semicolon. 
# using default shell as in /etc/default/usseradd by omitting -s /bin/bash
USERADD_PARAM:${PN} = "--uid 1200 -p '$(openssl passwd -6 ${USER_NAME})' ${USER_NAME}"

# GROUPADD_PARAM works the same way, which you set to the options
# you'd normally pass to the groupadd command.
GROUPADD_PARAM:${PN} = "-g 990 ${GRP_NAME}"

GROUPMEMS_PARAM = "--group ${GRP_NAME} --add ${USER_NAME}"

do_install:append () {
        # Add sudo accesses for user.
        install -d -m 710 ${D}${sysconfdir}/sudoers.d
        install -p -m 644 ${S}/10-john ${D}${sysconfdir}/sudoers.d/10-john
}

FILES:${PN} = " \
            /etc/sudoers.d \
            /etc/sudoers.d/10-john \
            "

# Prevents do_package failures with:
# debugsources.list: No such file or directory:
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
