# Jecal

Cryptographic API that extends the functionality of the JCA API to make the cryptographic functions easier to use.
Encapsulates JCA and Bouncy Castle methods and makes choices for users, i.e. they need less knowledge to use the layer.

# Usage examples

The following cryptographic concepts are implemented in the current prototype of the layer
All concepts work by first constructing an instance of the concept (by choice with a securely generated secret or an own one) and then using operational methods of it.

## Symmetric Encryption (AES)
To use symmetric encryption, create an instance of an `AESCipher` and use the operational method `encrypt` of it. Afterwards transmit ciphertext and key to the decrypting party.

### Create the instance and save key for decryption
```
IAESCipher aesCipher = new AESCipher();
AESKey = aesCipher.getKey();
```
### Encrypt a String or a bytearray
```
AESEncryptOutput aesOut = cipher.encrypt("plaintext");
```
### Decryption of this message
```IAESCipher decrypter = new AESCipher(aesKey);
 byte[] plaintext = decrypter.decrypt(aesOut); 
```
## Asymmetric Encryption (RSA)
  To use asymmetric encryption, create an `RSAKeyPair` by its static `generateKeyPair` method and use these keys for the constructors.
  
### Creating KeyPair and encryption instance to encrypt plaintext
```RSAKeyPair keypair = RSAKeyPair.generateRSAKeyPair();
IRSACipher rsaCipher = new RSACipher(keyPair.getPublicKey());
RSAEncryptOutput rsaOutput = rsa.encrypt("plaintext");
```

### To decrypt the ciphertext, construct `RSACipher` with the private key
```IRSACipher rsaDecrypter = new RSACipher(keyPair.getPrivateKey());
byte[] plaintext = rsaDecrypter.decrypt(rsaOutput);
```

## Password hashing
The password hashing encapsulates the BCrypt class of the Bouncy Castle API. Usage works simply instantiating an object and using its `hashPassword` method. A salt is generated randomly for the hash and can be taken out of the `HashedPassword` object that is returned.

```
IPasswordHash hasher = new PasswordHash();
HashedPassword pw = hasher.hashPassword("password") // byte array accepted, too
byte[] hash = pw.getHash();
byte[] salt = pw.getSalt();
```

## Message Authentication Code
For MACs a HMacSha256 implementation is used to provide the functionality of authenticating messages.
A randomly generated secret can be used, but developers can choose their own if they want.

```
IHMacSha256 mac = new HMacSha256();
MacSecret secretUsed = mac.getSecret(); // transmit this to receiver of message over secure channel
HMacSha256Output macOutput = mac.generateMac("message");
```

## Random number generator
The class `JecalRandom` directly encapsulates a seeded `SecureRandom` instance and can be used to generate `byte[]`, `int`, `float` or `boolean` values.

```
JecalRandom ran = new JecalRandom();
byte[] saltExample = ran.getRandomBytes(20); // byte array length 20
```

## Hash functions
Possible hash functions in this API are Sha256 and Sha512
```
IShaDigest sha = new Sha512Digest();
byte[] hash = sha.digest("plaintext"); 
```
