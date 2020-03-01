package de.adesso.jecal.crypto.mac;

public interface IHMacSha {
    MacSecret getSecret();
    HMacSha256Output generateMac(byte[] message);
    HMacSha256Output generateMac(String message);
}
