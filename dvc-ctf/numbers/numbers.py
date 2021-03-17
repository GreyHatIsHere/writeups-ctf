from pwn import *
import re

hostname = "challs.dvc.tf"
port = 3096
content = '780765271'
# content = a random number said by the bot
conn = remote(hostname, port)
while True:
    try:
        resp = conn.recv().decode().strip()
        conn.sendline(content)
        if "dvCTF{" in resp:
            print("Flag found: \n" + resp)
            break
        else:
            num = re.findall(r'\d+', resp) #this is to find the number in the answer received
            res = list(map(int, num))
            print("was thinking:" + str(res) + " number submited: " + content + '\n')
    except KeyboardInterrupt:
        break
conn.close()
