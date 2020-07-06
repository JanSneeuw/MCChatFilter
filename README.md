#Simple Chat Filter:

**What will be blocked:**
* Advertisements
* Ip addresses
* Curse words

##Curse words:
All curse words setup in the configuration section 'curse_words' in the config.yml
will be blocked. When a legitimate word contains a curse word such as assassin which contains
'ass', you can put this in the 'curse_bypass' section.
**The following patterns will be blocked:**
* Twat
* T wat (It doesn't matter where and how many spaces there are)
* Tw@t

##IP addresses:
**The following IP patterns will be blocked:**
* 1.1.1.1
* 255.255.255.255
* 192.168.1.1
* 10.10.1.1
* 132.254.111.10
* 26.10.2.10
* 127.0.0.1

##Advertising:
Blocked domains can be setup in the config.yml, all ads containing such a domain will be blocked.
To block messages containing http or https you could also add http:// and https://.

##Bypassing:
Using the permissions 'SCF.BYPASSIPFILTER' and 'SCF.BYPASSADFILTER' you can let a player
bypass the IP and the Advertisement filters.
