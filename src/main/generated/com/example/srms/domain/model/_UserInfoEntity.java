package com.example.srms.domain.model;

/** */
@javax.annotation.Generated(value = { "Doma", "2.19.0" }, date = "2019-03-03T16:09:04.457+0900")
public final class _UserInfoEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<com.example.srms.domain.model.UserInfoEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.19.0");
    }

    private static final _UserInfoEntity __singleton = new _UserInfoEntity();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    /** the id */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, com.example.srms.domain.model.UserInfoEntity, java.lang.String, Object> $id = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<>(com.example.srms.domain.model.UserInfoEntity.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "id", "", __namingType, false);

    /** the name */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.example.srms.domain.model.UserInfoEntity, java.lang.String, Object> $name = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.example.srms.domain.model.UserInfoEntity.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "name", "", __namingType, true, true, false);

    /** the password */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.example.srms.domain.model.UserInfoEntity, java.lang.String, Object> $password = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.example.srms.domain.model.UserInfoEntity.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "password", "", __namingType, true, true, false);

    private final java.util.function.Supplier<org.seasar.doma.jdbc.entity.NullEntityListener<com.example.srms.domain.model.UserInfoEntity>> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.srms.domain.model.UserInfoEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.srms.domain.model.UserInfoEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.srms.domain.model.UserInfoEntity, ?>> __entityPropertyTypeMap;

    private _UserInfoEntity() {
        __listenerSupplier = () -> ListenerHolder.listener;
        __immutable = false;
        __name = "UserInfoEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "users";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.srms.domain.model.UserInfoEntity, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.srms.domain.model.UserInfoEntity, ?>> __list = new java.util.ArrayList<>(3);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.srms.domain.model.UserInfoEntity, ?>> __map = new java.util.HashMap<>(3);
        __idList.add($id);
        __list.add($id);
        __map.put("id", $id);
        __list.add($name);
        __map.put("name", $name);
        __list.add($password);
        __map.put("password", $password);
        __idPropertyTypes = java.util.Collections.unmodifiableList(__idList);
        __entityPropertyTypes = java.util.Collections.unmodifiableList(__list);
        __entityPropertyTypeMap = java.util.Collections.unmodifiableMap(__map);
    }

    @Override
    public org.seasar.doma.jdbc.entity.NamingType getNamingType() {
        return __namingType;
    }

    @Override
    public boolean isImmutable() {
        return __immutable;
    }

    @Override
    public String getName() {
        return __name;
    }

    @Override
    public String getCatalogName() {
        return __catalogName;
    }

    @Override
    public String getSchemaName() {
        return __schemaName;
    }

    @Override
    public String getTableName() {
        return getTableName(org.seasar.doma.jdbc.Naming.DEFAULT::apply);
    }

    @Override
    public String getTableName(java.util.function.BiFunction<org.seasar.doma.jdbc.entity.NamingType, String, String> namingFunction) {
        if (__tableName.isEmpty()) {
            return namingFunction.apply(__namingType, __name);
        }
        return __tableName;
    }

    @Override
    public boolean isQuoteRequired() {
        return __isQuoteRequired;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preInsert(com.example.srms.domain.model.UserInfoEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<com.example.srms.domain.model.UserInfoEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(com.example.srms.domain.model.UserInfoEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<com.example.srms.domain.model.UserInfoEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(com.example.srms.domain.model.UserInfoEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<com.example.srms.domain.model.UserInfoEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(com.example.srms.domain.model.UserInfoEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<com.example.srms.domain.model.UserInfoEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(com.example.srms.domain.model.UserInfoEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<com.example.srms.domain.model.UserInfoEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(com.example.srms.domain.model.UserInfoEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<com.example.srms.domain.model.UserInfoEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.srms.domain.model.UserInfoEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.srms.domain.model.UserInfoEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.example.srms.domain.model.UserInfoEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, com.example.srms.domain.model.UserInfoEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, com.example.srms.domain.model.UserInfoEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.TenantIdPropertyType<java.lang.Object, com.example.srms.domain.model.UserInfoEntity, ?, ?> getTenantIdPropertyType() {
        return null;
    }

    @Override
    public com.example.srms.domain.model.UserInfoEntity newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<com.example.srms.domain.model.UserInfoEntity, ?>> __args) {
        com.example.srms.domain.model.UserInfoEntity entity = new com.example.srms.domain.model.UserInfoEntity();
        if (__args.get("id") != null) __args.get("id").save(entity);
        if (__args.get("name") != null) __args.get("name").save(entity);
        if (__args.get("password") != null) __args.get("password").save(entity);
        return entity;
    }

    @Override
    public Class<com.example.srms.domain.model.UserInfoEntity> getEntityClass() {
        return com.example.srms.domain.model.UserInfoEntity.class;
    }

    @Override
    public com.example.srms.domain.model.UserInfoEntity getOriginalStates(com.example.srms.domain.model.UserInfoEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(com.example.srms.domain.model.UserInfoEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _UserInfoEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _UserInfoEntity newInstance() {
        return new _UserInfoEntity();
    }

    private static class ListenerHolder {
        private static org.seasar.doma.jdbc.entity.NullEntityListener<com.example.srms.domain.model.UserInfoEntity> listener = new org.seasar.doma.jdbc.entity.NullEntityListener<>();
    }

}
