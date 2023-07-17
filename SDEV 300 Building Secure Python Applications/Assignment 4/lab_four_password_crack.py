"""Create use Python code to generate ten (10) passwords with different hashing algorithms
 then use a popular online password cracking website to see if the passwords can be cracked. """

import hashlib
# input a message to encode
print('Enter a message to encode:')
message = input()
# encode it to bytes using UTF-8 encoding
message = message.encode()
# hash with MD5 (very weak)
print("# This is encoded to UTF-8 and hashed to MD5:")
print(hashlib.md5(message).hexdigest())
# Let's try a stronger SHA-2 family
print("# This is SHA-2 Family:")
print(hashlib.sha256(message).hexdigest())
print(hashlib.sha512(message).hexdigest())
