/*
 * Copyright 2012-2013 Continuuity,Inc. All Rights Reserved.
 */
package com.continuuity.api.workflow;

/**
 *
 */
public abstract class AbstractWorkFlowAction implements WorkFlowAction {

  private final String name;
  private WorkFlowContext context;

  protected AbstractWorkFlowAction() {
    name = getClass().getSimpleName();
  }

  protected AbstractWorkFlowAction(String name) {
    this.name = name;
  }

  @Override
  public WorkFlowActionSpecification configure() {
    return WorkFlowActionSpecification.Builder.with()
      .setName(getName())
      .setDescription(getDescription())
      .build();
  }

  @Override
  public void initialize(WorkFlowContext context) throws Exception {
    this.context = context;
  }

  @Override
  public void destroy() {
    // No-op
  }

  protected final WorkFlowContext getContext() {
    return context;
  }

  /**
   * @return {@link Class#getSimpleName() Simple classname} of this {@link WorkFlowAction}.
   */
  protected String getName() {
    return name;
  }

  /**
   * @return A descriptive message about this {@link WorkFlowAction}.
   */
  protected String getDescription() {
    return String.format("WorkFlowAction of %s.", getName());
  }
}
