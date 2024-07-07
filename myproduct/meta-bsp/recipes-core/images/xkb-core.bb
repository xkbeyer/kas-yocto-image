SUMMARY = "A console-only image that fully supports the target device hardware."
# Include the base image.
include recipes-core/images/core-image-minimal.bb

#inherit extrausers
#EXTRA_USERS_PARAMS = " usermod -p '$(openssl passwd -6 master)' root; "

IMAGE_INSTALL += " \
        bash \
        whiptail \
        jq \
        openssl \
        sudo \
        addusers \
        mc \
        hello-world \
	"
