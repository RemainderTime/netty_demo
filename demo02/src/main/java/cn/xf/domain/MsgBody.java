// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MsgInfo.proto

package cn.xf.domain;

/**
 * Protobuf type {@code cn.xf.domain.MsgBody}
 */
public final class MsgBody extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:cn.xf.domain.MsgBody)
    MsgBodyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MsgBody.newBuilder() to construct.
  private MsgBody(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MsgBody() {
    channelId_ = "";
    msgInfo_ = "";
  }

//  @java.lang.Override
//  @SuppressWarnings({"unused"})
//  protected java.lang.Object newInstance(
//      UnusedPrivateParameter unused) {
//    return new MsgBody();
//  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cn.xf.domain.MsgInfo.internal_static_cn_xf_domain_MsgBody_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.xf.domain.MsgInfo.internal_static_cn_xf_domain_MsgBody_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.xf.domain.MsgBody.class, cn.xf.domain.MsgBody.Builder.class);
  }

  public static final int CHANNELID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object channelId_ = "";
  /**
   * <code>string channelId = 1;</code>
   * @return The channelId.
   */
  @java.lang.Override
  public java.lang.String getChannelId() {
    java.lang.Object ref = channelId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      channelId_ = s;
      return s;
    }
  }
  /**
   * <code>string channelId = 1;</code>
   * @return The bytes for channelId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getChannelIdBytes() {
    java.lang.Object ref = channelId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      channelId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MSGINFO_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object msgInfo_ = "";
  /**
   * <code>string msgInfo = 2;</code>
   * @return The msgInfo.
   */
  @java.lang.Override
  public java.lang.String getMsgInfo() {
    java.lang.Object ref = msgInfo_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      msgInfo_ = s;
      return s;
    }
  }
  /**
   * <code>string msgInfo = 2;</code>
   * @return The bytes for msgInfo.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMsgInfoBytes() {
    java.lang.Object ref = msgInfo_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      msgInfo_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(channelId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, channelId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(msgInfo_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, msgInfo_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(channelId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, channelId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(msgInfo_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, msgInfo_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof cn.xf.domain.MsgBody)) {
      return super.equals(obj);
    }
    cn.xf.domain.MsgBody other = (cn.xf.domain.MsgBody) obj;

    if (!getChannelId()
        .equals(other.getChannelId())) return false;
    if (!getMsgInfo()
        .equals(other.getMsgInfo())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CHANNELID_FIELD_NUMBER;
    hash = (53 * hash) + getChannelId().hashCode();
    hash = (37 * hash) + MSGINFO_FIELD_NUMBER;
    hash = (53 * hash) + getMsgInfo().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.xf.domain.MsgBody parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.xf.domain.MsgBody parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.xf.domain.MsgBody parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.xf.domain.MsgBody parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.xf.domain.MsgBody parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.xf.domain.MsgBody parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.xf.domain.MsgBody parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.xf.domain.MsgBody parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.xf.domain.MsgBody parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.xf.domain.MsgBody parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.xf.domain.MsgBody parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.xf.domain.MsgBody parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(cn.xf.domain.MsgBody prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code cn.xf.domain.MsgBody}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:cn.xf.domain.MsgBody)
      cn.xf.domain.MsgBodyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.xf.domain.MsgInfo.internal_static_cn_xf_domain_MsgBody_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.xf.domain.MsgInfo.internal_static_cn_xf_domain_MsgBody_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.xf.domain.MsgBody.class, cn.xf.domain.MsgBody.Builder.class);
    }

    // Construct using cn.xf.domain.MsgBody.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      channelId_ = "";
      msgInfo_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.xf.domain.MsgInfo.internal_static_cn_xf_domain_MsgBody_descriptor;
    }

    @java.lang.Override
    public cn.xf.domain.MsgBody getDefaultInstanceForType() {
      return cn.xf.domain.MsgBody.getDefaultInstance();
    }

    @java.lang.Override
    public cn.xf.domain.MsgBody build() {
      cn.xf.domain.MsgBody result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public cn.xf.domain.MsgBody buildPartial() {
      cn.xf.domain.MsgBody result = new cn.xf.domain.MsgBody(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(cn.xf.domain.MsgBody result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.channelId_ = channelId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.msgInfo_ = msgInfo_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof cn.xf.domain.MsgBody) {
        return mergeFrom((cn.xf.domain.MsgBody)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.xf.domain.MsgBody other) {
      if (other == cn.xf.domain.MsgBody.getDefaultInstance()) return this;
      if (!other.getChannelId().isEmpty()) {
        channelId_ = other.channelId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getMsgInfo().isEmpty()) {
        msgInfo_ = other.msgInfo_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              channelId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              msgInfo_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object channelId_ = "";
    /**
     * <code>string channelId = 1;</code>
     * @return The channelId.
     */
    public java.lang.String getChannelId() {
      java.lang.Object ref = channelId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        channelId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string channelId = 1;</code>
     * @return The bytes for channelId.
     */
    public com.google.protobuf.ByteString
        getChannelIdBytes() {
      java.lang.Object ref = channelId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        channelId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string channelId = 1;</code>
     * @param value The channelId to set.
     * @return This builder for chaining.
     */
    public Builder setChannelId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      channelId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string channelId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearChannelId() {
      channelId_ = getDefaultInstance().getChannelId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string channelId = 1;</code>
     * @param value The bytes for channelId to set.
     * @return This builder for chaining.
     */
    public Builder setChannelIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      channelId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object msgInfo_ = "";
    /**
     * <code>string msgInfo = 2;</code>
     * @return The msgInfo.
     */
    public java.lang.String getMsgInfo() {
      java.lang.Object ref = msgInfo_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        msgInfo_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string msgInfo = 2;</code>
     * @return The bytes for msgInfo.
     */
    public com.google.protobuf.ByteString
        getMsgInfoBytes() {
      java.lang.Object ref = msgInfo_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        msgInfo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string msgInfo = 2;</code>
     * @param value The msgInfo to set.
     * @return This builder for chaining.
     */
    public Builder setMsgInfo(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      msgInfo_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string msgInfo = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMsgInfo() {
      msgInfo_ = getDefaultInstance().getMsgInfo();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string msgInfo = 2;</code>
     * @param value The bytes for msgInfo to set.
     * @return This builder for chaining.
     */
    public Builder setMsgInfoBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      msgInfo_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:cn.xf.domain.MsgBody)
  }

  // @@protoc_insertion_point(class_scope:cn.xf.domain.MsgBody)
  private static final cn.xf.domain.MsgBody DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.xf.domain.MsgBody();
  }

  public static cn.xf.domain.MsgBody getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MsgBody>
      PARSER = new com.google.protobuf.AbstractParser<MsgBody>() {
    @java.lang.Override
    public MsgBody parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<MsgBody> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MsgBody> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public cn.xf.domain.MsgBody getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

