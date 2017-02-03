package MNServer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.io.Serializable;


public class MNEncoder extends ObjectEncoder {
@Override
protected void encode(ChannelHandlerContext ctx, Serializable msg, ByteBuf out)
{

}




}
